package lee.java.exam04;
import java.io.IOException;
import java.net.*;

public class ServerSocketEx {
	public static void main(String[] args) {
		System.out.println("[����]");
		try {
			// Ŭ���̾�Ʈ�� �޾Ƶ��̱� ���� ServerSocket ����  -> ��Ʈ : 3000
			ServerSocket server = new ServerSocket(3000);
			System.out.println("#���� �غ� �Ϸ�");
			while(true) {
				// ���� ���� ���� : �����ڰ� �߻��� ������ ������ ���
				Socket socket = server.accept();
				if(socket != null) System.out.println("#Ŭ���̾�Ʈ ����");
				// ������ Ŭ���̾�Ʈ IP�� �˾Ƴ��� ���� ��ü �ޱ� (Ŭ���̾�Ʈ ��ü)
				InetAddress client = socket.getInetAddress();
				String clientIp = client.getHostAddress();
				System.out.println("* " + clientIp + "�� ����");
			}
		} catch(IOException e) { // ���� ��Ʈ ���� ó�� : �ش� ��Ʈ�� ������̸� IOException
			System.err.println("!Error! �ش� ��Ʈ�� ������Դϴ�.");
		}
	}
}
