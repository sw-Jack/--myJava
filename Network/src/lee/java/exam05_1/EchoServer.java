package lee.java.exam05_1;
import java.io.*;
import java.net.*;
public class EchoServer {

	public EchoServer() {
		System.out.println("[����]");
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("#���� ����");

			Socket socket = server.accept();
			System.out.println("#���� �غ� �Ϸ�");
			
			InetAddress client = socket.getInetAddress();
			String clientIp = client.getHostAddress();
			System.out.println("#[" + clientIp + "] ����\n");
				
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
 			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // Ű����� ���� �Է�
 			while(true) {
				String message = br.readLine();
				System.out.println("[" + clientIp + " ���� �޼���] " + message);
				
	            System.out.print("������ �޼��� : ");
	            String reply = keyboard.readLine(); 
	            
	            bw.write(reply + "\n"); 
	            bw.flush();
			}
		} catch (IOException e) {
			System.err.println("�ش� ��Ʈ�� ������Դϴ�.");
		}
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}
}
