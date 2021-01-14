package lee.java.exam10;
import java.io.*;
import java.net.*;

public class ProtocolClient {
	Socket socket = null;
	BufferedWriter bw = null;
	BufferedReader br = null;
	BufferedReader clientInput = null;
	
	public ProtocolClient() {
		System.out.println("[Ŭ���̾�Ʈ]");
		try {
			socket = new Socket("localhost", 5000);
		} catch(UnknownHostException e) {
			System.err.println("������ ã�� �� �����ϴ�.");
			System.exit(0);
		} catch(IOException e) {
			System.err.println("������ ������ �� �����ϴ�.");
			System.exit(0);
		}
		
		try {
			bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			clientInput = new BufferedReader(
					new InputStreamReader(System.in));
			
			while(true) {
				// �޼��� �۽�
				String send = clientInput.readLine();
				bw.write(send + "\n");
				bw.flush();
				String[] words = send.split(":");
				// �޼��� ����
				String rec = br.readLine();
				System.out.println("[from.����] " + rec);
				
				Protocol protocol = new Protocol();
				if(words[0].equals(protocol.EXIT)) {
					throw new IOException();
				}
			}
		} catch(IOException e) {
			System.err.println("������ ������ ���������ϴ�.");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new ProtocolClient();
	}
}
