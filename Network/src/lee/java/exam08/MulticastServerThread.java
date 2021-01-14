package lee.java.exam08;
import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServerThread extends Thread {
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw; // auto-flush 기능 때문에 BufferedWriter 댜신 사용
	private ArrayList<MulticastServerThread> clientList;
	private InetAddress client = null;
	private String clientIp = null;
	public MulticastServerThread(
			ArrayList<MulticastServerThread> clientList, Socket socket) {
		this.clientList = clientList;
		this.socket = socket;
		client = this.socket.getInetAddress();
		clientIp = client.getHostAddress();
	}
	
	// 스레드 특성에 맞게 여기 저기서 순서없이 메세지가 들어오기 때문에 "동기화" 설정 
	public synchronized void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());

			while(true) {
				// 메세지 수신
				String rec = br.readLine();
				System.out.println("[" + clientIp + " 님의 메세지] " + rec);
				// 해당 클라이언트의 메세지를 접속된 모든 클라이언트에게 송신
				broadcasting("[" + clientIp + "] " + rec);
			}
		} catch(IOException e) {
			// 클라이언트와 연결이 끊어진 경우 클라이언트 목록(ArrayList)에서 삭제
			clientList.remove(this);
			try {
				// 다른 모든 클라이언트들에게도 연결이 끊어진 사실을 알림
				broadcasting("[" + clientIp + "] 님과의 연결이 끊어졌습니다.");
			} catch(IOException ee) {}
		} 
	}
	
	public void broadcasting(String message) throws IOException {
		// clientList에 저장된 스레드(접속한 클라이언트) 수만큼 반복하면서 
		// 각각의 스레드(클라이언트)의 sendMessage 메서드를 호출해서 연결된 클라이언트에게 송신
		for(MulticastServerThread th : clientList) {
			th.sendMessage(message);
		}
	}
	
	public void sendMessage(String message) throws IOException {
		pw.println(message);
		pw.flush();
	}
}
