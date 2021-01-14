package lee.java.exam07;
import java.io.*;
import java.net.*;

public class UnicastServerThread extends Thread {
	
	Socket socket = null;
	BufferedReader serverInput = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	InetAddress client =  null;
	String clientIp = null;
	
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
		client = this.socket.getInetAddress();
		clientIp = this.client.getHostAddress();
	}
	
	public void run() {
		try {
			serverInput = new BufferedReader(
					new InputStreamReader(System.in));
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			
			
			while(true) {
				// 메세지 수신
				String rec = br.readLine();
				System.out.println("[" + clientIp + " 님의 메세지] " + rec);
				
				// 메세지 송신
				System.out.print("#메세지 입력 : ");
				String send = serverInput.readLine();
				bw.write(send + "\n");
				bw.flush();
			}
		} catch(IOException e) { // 클라이언트와 연결이 끊어진 경우 
			System.err.println("[" + clientIp + "] 님과의 연결이 끊어졌습니다.");
		}
	}
}
