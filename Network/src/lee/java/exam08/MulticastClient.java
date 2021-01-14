package lee.java.exam08;
import java.io.*;
import java.net.*;

public class MulticastClient {
	private Socket socket;
	private BufferedReader clientInput;
	private BufferedReader br;
	private PrintWriter pw;
	
	public MulticastClient() {
		System.out.println("[클라이언트]");
		try {
			socket = new Socket("localhost", 7000);
			System.out.println("[서버 연결]\n");
			
			clientInput = new BufferedReader(
					new InputStreamReader(System.in));
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			// 서버가 전송한 메세지를 읽어들이기(수신) 위한 전용 Thread 생성
			// 읽기 전용(Read) 스레드인 MulticastClientThread 생성시
			// 서버가 전송한 메세지를 읽어들 수 있는 스트림도 같이 전달
			MulticastClientThread clientThread  = new MulticastClientThread(br);
			clientThread.start();
			
			// 클라이언트 송신
			while(true) {
				String send = clientInput.readLine();
				pw.println(send);
			}
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MulticastClient();
	}
}
