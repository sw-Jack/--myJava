package lee.java.exam08;
import java.io.*;
import java.net.*;

public class MulticastClient {
	private Socket socket;
	private BufferedReader clientInput;
	private BufferedReader br;
	private PrintWriter pw;
	
	public MulticastClient() {
		System.out.println("[Ŭ���̾�Ʈ]");
		try {
			socket = new Socket("localhost", 7000);
			System.out.println("[���� ����]\n");
			
			clientInput = new BufferedReader(
					new InputStreamReader(System.in));
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			// ������ ������ �޼����� �о���̱�(����) ���� ���� Thread ����
			// �б� ����(Read) �������� MulticastClientThread ������
			// ������ ������ �޼����� �о�� �� �ִ� ��Ʈ���� ���� ����
			MulticastClientThread clientThread  = new MulticastClientThread(br);
			clientThread.start();
			
			// Ŭ���̾�Ʈ �۽�
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
