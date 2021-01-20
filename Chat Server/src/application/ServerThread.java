package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ServerThread {
	Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
		receive();
	}
	
	// Ŭ���̾�Ʈ�κ��� �޼����� ���� �޴� �޼��� (���� ������)
	public void receive() {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						int length = in.read(buffer);
						if(length == -1) throw new IOException(); // �о���� �� ������ ������ ���� �߻���Ű��
						System.out.println("[�޼��� ���� ����] " 
									+ socket.getRemoteSocketAddress()
									+ " : " + Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8"); // �ѱ۵� �о�� �� �ֵ��� UTF-8�� ���ڵ�����
						System.out.println("���� : " + message);
						// Ŭ���̾�Ʈ�� �޼����� ������ �ٸ� Ŭ���̾�Ʈ�鿡�Ե� �޼��� ����
						for(ServerThread serverThread : ServerMain.clients) {
							serverThread.send(message);
						}
					}
				} catch(Exception e) {
					try {
						System.out.println("[�޼��� ���� ����] "
								+ socket.getRemoteSocketAddress()
								+ " : " + Thread.currentThread().getName());
					} catch(Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		};
		ServerMain.threadPool.submit(thread); // main Ŭ������ threadPool�� �ش� ������ ����
	}
	
	// Ŭ���̾�Ʈ���� �޼����� �����ϴ� �޼��� (���� ������)
	public void send(String message) {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
					System.out.println("�۽� : " + message);
					System.out.println("[�޼��� �۽� ����] " 
							+ socket.getRemoteSocketAddress()
							+ " : " + Thread.currentThread().getName());
				} catch(Exception e) {
					try {
						System.out.println("[�޼��� �۽� ����]"
								+ socket.getRemoteSocketAddress()
								+ " : " + Thread.currentThread().getName());
						ServerMain.clients.remove(ServerThread.this); // ������ ������ ���� Ŭ���̾�Ʈ ����
						socket.close(); // ���� �ݱ�
					} catch(Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		};
		ServerMain.threadPool.submit(thread);
	}
}
