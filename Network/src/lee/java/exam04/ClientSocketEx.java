package lee.java.exam04;
import java.io.IOException;
import java.net.*;

public class ClientSocketEx {
	public static void main(String[] args) {
		System.out.println("[Ŭ���̾�Ʈ]");
		// Ŭ���̾�Ʈ�� ������ ����
		try {
			Socket socket = new Socket("localhost", 3000);
		} catch (UnknownHostException e) {
			System.err.println("!Error! �ش� �ּҰ� �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			System.err.println("!Error! �ش� ��Ʈ�� ������Դϴ�.");
		}
		System.out.println("#���� ����");
	}
}
