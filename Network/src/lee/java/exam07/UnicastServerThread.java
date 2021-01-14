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
				// �޼��� ����
				String rec = br.readLine();
				System.out.println("[" + clientIp + " ���� �޼���] " + rec);
				
				// �޼��� �۽�
				System.out.print("#�޼��� �Է� : ");
				String send = serverInput.readLine();
				bw.write(send + "\n");
				bw.flush();
			}
		} catch(IOException e) { // Ŭ���̾�Ʈ�� ������ ������ ��� 
			System.err.println("[" + clientIp + "] �԰��� ������ ���������ϴ�.");
		}
	}
}
