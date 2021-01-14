package lee.java.exam07;
import java.io.*;
import java.net.*;

public class UnicastServer {
	InetAddress client = null;
	String clientIp = null;
	
	public UnicastServer() {
		System.out.println("[����]");
		ServerSocket server = null;
		try {
			server = new ServerSocket(5000);
		} catch(IOException e) {
			System.err.println("�ش� ��Ʈ�� ������Դϴ�.");
			System.exit(0);
		}
		System.out.println("#���� �غ� �Ϸ�");
		try {
			while(true) {	
				Socket socket = server.accept(); // Ŭ���̾�Ʈ ���� ������ ���� ���

				// Ŭ���̾�Ʈ ����
				client = socket.getInetAddress();
				clientIp = client.getHostAddress();
				System.out.println("#[" + clientIp + "] ����\n");
				// Ŭ���̾�Ʈ�� �����ϰ� �Ǹ� ���� ����
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
