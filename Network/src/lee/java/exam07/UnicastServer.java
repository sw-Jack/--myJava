package lee.java.exam07;
import java.io.*;
import java.net.*;

public class UnicastServer {
	InetAddress client = null;
	String clientIp = null;
	
	public UnicastServer() {
		System.out.println("[서버]");
		ServerSocket server = null;
		try {
			server = new ServerSocket(5000);
		} catch(IOException e) {
			System.err.println("해당 포트가 사용중입니다.");
			System.exit(0);
		}
		System.out.println("#서버 준비 완료");
		try {
			while(true) {	
				Socket socket = server.accept(); // 클라이언트 접속 전까지 서버 대기

				// 클라이언트 접속
				client = socket.getInetAddress();
				clientIp = client.getHostAddress();
				System.out.println("#[" + clientIp + "] 접속\n");
				// 클라이언트가 접속하게 되면 다음 실행
				UnicastServerThread serverThread = 
						new UnicastServerThread(socket);
				serverThread.start();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UnicastServer();
	}
}
