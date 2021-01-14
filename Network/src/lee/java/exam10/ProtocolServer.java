package lee.java.exam10;
import java.io.*;
import java.net.*;

public class ProtocolServer {

	ServerSocket server = null;
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public ProtocolServer() throws IOException {
		System.out.println("[����]");
		server = new ServerSocket(5000);
		System.out.println("#���� �غ�");
		socket = server.accept();
		
		bw = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		while(true) {
			String rec = br.readLine();
			String[] words = rec.split(":");
			
			Protocol protocol = new Protocol();
			if(words[0].equals(protocol.ENTER)) {
				// ����
				enter(words);
			} else if(words[0].equals(protocol.EXIT)) {
				// ����
				exit(words);
			} else if(words[0].equals(protocol.SEND_MESSAGE)) {
				// �޼��� ����
				sendMessage(words);
			} else if(words[0].equals(protocol.SECRET_MESSAGE)) {
				// �ӼӸ�
				sendSecretMessage(words);
			} else {
				bw.write("�߸��� ��û�Դϴ�.");
				bw.flush();
			}
		}
	}	
	
	public void enter(String[] arr) throws IOException {
		// 100:���̵� 
		System.out.println(arr[1] + "���� �����ϼ̽��ϴ�.");
		bw.write(arr[1] + "���� �����ϼ̽��ϴ�.\n");
		bw.flush();
	}
	
	public void exit(String[] arr) throws IOException {
		// 200:���̵�
		System.out.println(arr[1] + "���� �����ϼ̽��ϴ�.");
		bw.write(arr[1] + "���� �����ϼ̽��ϴ�.\n");
		bw.flush();
	}
	
	public void sendMessage(String[] arr) throws IOException {
		// 300:���̵�:�޼���
		System.out.println("[" + arr[1] + "] " + arr[2]);
		bw.write("[" + arr[1] + "] " + arr[2] + "\n");
		bw.flush();
	}
	
	public void sendSecretMessage(String[] arr) throws IOException {
		System.out.println("<" + arr[1] + ">" + arr[3]);
		bw.write("<" + arr[1] + ">" + arr[3] + "\n");
		bw.flush();
	}

	public static void main(String[] args) {
		try {
			new ProtocolServer();
		} catch(IOException e) {}
	}
}
