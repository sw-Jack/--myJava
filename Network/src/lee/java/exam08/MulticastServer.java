package lee.java.exam08;
import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServer {
	private ArrayList<MulticastServerThread> clientList = 
			new ArrayList<MulticastServerThread>();
	private ServerSocket server = null;
	
	public MulticastServer() {
		System.out.println("[����]");
		try {
			server = new ServerSocket(7000);
			System.out.println("#���� �غ�");
			
			while(true) {
				Socket socket = server.accept(); // ������ Ŭ���̾�Ʈ ���� ���

				// Ŭ���̾�Ʈ�� �����ϰ� �Ǹ� ���� ����
				InetAddress client = socket.getInetAddress();
				String clientIp = client.getHostAddress();
				System.out.println("[" + clientIp + "] �� ����");
				
				MulticastServerThread serverThread = 
						new MulticastServerThread(clientList, socket);
				serverThread.start(); // Thread ����
				
				// ������ MulticastServerThread ��ü, �� �����ϴ� Ŭ���̾�Ʈ����
				// ������ clientList�� ����
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
