package lee.java.exam08;
import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServerThread extends Thread {
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw; // auto-flush ��� ������ BufferedWriter ���� ���
	private ArrayList<MulticastServerThread> clientList;
	private InetAddress client = null;
	private String clientIp = null;
	public MulticastServerThread(
			ArrayList<MulticastServerThread> clientList, Socket socket) {
		this.clientList = clientList;
		this.socket = socket;
		client = this.socket.getInetAddress();
		clientIp = client.getHostAddress();
	}
	
	// ������ Ư���� �°� ���� ���⼭ �������� �޼����� ������ ������ "����ȭ" ���� 
	public synchronized void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());

			while(true) {
				// �޼��� ����
				String rec = br.readLine();
				System.out.println("[" + clientIp + " ���� �޼���] " + rec);
				// �ش� Ŭ���̾�Ʈ�� �޼����� ���ӵ� ��� Ŭ���̾�Ʈ���� �۽�
				broadcasting("[" + clientIp + "] " + rec);
			}
		} catch(IOException e) {
			// Ŭ���̾�Ʈ�� ������ ������ ��� Ŭ���̾�Ʈ ���(ArrayList)���� ����
			clientList.remove(this);
			try {
				// �ٸ� ��� Ŭ���̾�Ʈ�鿡�Ե� ������ ������ ����� �˸�
				broadcasting("[" + clientIp + "] �԰��� ������ ���������ϴ�.");
			} catch(IOException ee) {}
		} 
	}
	
	public void broadcasting(String message) throws IOException {
		// clientList�� ����� ������(������ Ŭ���̾�Ʈ) ����ŭ �ݺ��ϸ鼭 
		// ������ ������(Ŭ���̾�Ʈ)�� sendMessage �޼��带 ȣ���ؼ� ����� Ŭ���̾�Ʈ���� �۽�
		for(MulticastServerThread th : clientList) {
			th.sendMessage(message);
		}
	}
	
	public void sendMessage(String message) throws IOException {
		pw.println(message);
		pw.flush();
	}
}
