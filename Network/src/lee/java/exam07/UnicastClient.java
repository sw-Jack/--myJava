package lee.java.exam07;
import java.io.*;
import java.net.*;

public class UnicastClient {
	Socket socket = null;
	BufferedReader clientInput = null; 
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public UnicastClient() {
		System.out.println("[Ŭ���̾�Ʈ]");
		try {
			socket = new Socket("localhost", 5000);
		} catch(UnknownHostException e) {
			System.err.println("�ش� ������ ã�� �� �����ϴ�.");
			System.exit(0);
		} catch(IOException e) {
			System.err.println("�ش� ��Ʈ�� �̹� ������̰ų� ������ ������ �� �����ϴ�.");
			System.exit(0);
		}
		System.out.println("#���� ���� �Ϸ�\n");
		try {
			clientInput = new BufferedReader(
					new InputStreamReader(System.in));
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				// �޼��� �۽�
				System.out.print("#�޼��� �Է� : ");
				String send = clientInput.readLine();
				bw.write(send + "\n");
				bw.flush();
				
				// �޼��� ����
				String rec = br.readLine();
				System.out.println("[���� �޼���] " + rec);
			}
		} catch(IOException e) {
			System.err.println("������ ������ ���������ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		new UnicastClient();
	}
}
