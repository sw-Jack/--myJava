package lee.java.exam09;
import java.io.*;
import java.net.*;

public class ObjectServer {
	
	public ObjectServer() {
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("[���� �غ�]");
			 
			Socket socket = server.accept(); // Ŭ���̾�Ʈ ���� ������ ���� ���
			
			// Ŭ���̾�Ʈ ����
			System.out.println("[Ŭ���̾�Ʈ ����]");
			System.out.println("[client : " + socket.getInetAddress() + "]");
			// Ŭ���̾�Ʈ-�������� ������ ���� �ۼ��� ��Ʈ��
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			// ��ü �ۼ��� ��Ʈ��
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// Ŭ���̾�Ʈ�� ���� ��ü(MyMember ��) ����
			MyMember clientMember = (MyMember)ois.readObject();
			System.out.println("[Ŭ���̾�Ʈ ����]");
			System.out.println("- ���̵�    : " + clientMember.getId());
			System.out.println("- ��й�ȣ : " + clientMember.getPwd());
			
			// Ŭ���̾�Ʈ���� �޼��� �۽�
			oos.writeObject("[from.����] " + clientMember.getId() + "�� ȯ���մϴ�^^");
		}  catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ObjectServer();
	}
}
