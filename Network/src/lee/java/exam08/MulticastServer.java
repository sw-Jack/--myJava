package lee.java.exam08;
import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServer {
	private ArrayList<MulticastServerThread> clientList = 
			new ArrayList<MulticastServerThread>();
	private ServerSocket server = null;
	
	public MulticastServer() {
		System.out.println("[서버]");
		try {
			server = new ServerSocket(7000);
			System.out.println("#서버 준비");
			
			while(true) {
				Socket socket = server.accept(); // 서버는 클라이언트 접속 대기

				// 클라이언트가 접속하게 되면 다음 실행
				InetAddress client = socket.getInetAddress();
				String clientIp = client.getHostAddress();
				System.out.println("[" + clientIp + "] 님 접속");
				
				MulticastServerThread serverThread = 
						new MulticastServerThread(clientList, socket);
				serverThread.start(); // Thread 시작
				
				// 생성된 MulticastServerThread 객체, 즉 접속하는 클라이언트들의
				// 정보를 clientList에 저장
				clientList.add(serverThread); 
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new MulticastServer();
	}
}
