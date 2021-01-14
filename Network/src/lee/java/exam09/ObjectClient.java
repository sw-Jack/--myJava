package lee.java.exam09;
import java.io.*;
import java.net.*;

public class ObjectClient {

	public ObjectClient() {
		try {
			Socket socket = new Socket("localhost", 5000);
			
			ObjectOutputStream oos = 
					new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = 
					new ObjectInputStream(socket.getInputStream());
			
			// Ŭ���̾�Ʈ ���� �Է��� ���� MyMember ��ü ����
			MyMember member = new MyMember();
			member.setId("�̰����ڹٳ�");
			member.setPwd("java1234");
			
			// �Է��� Ŭ���̾�Ʈ ���� ��ü�� ������ ����
			oos.writeObject(member);
			
			// ���� �޼��� ����
			String rec = (String)ois.readObject();
			System.out.println(rec);
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ObjectClient();
	}
}
