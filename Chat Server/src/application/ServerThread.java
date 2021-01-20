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
	
	// 클라이언트로부터 메세지를 전달 받는 메서드 (서버 스레드)
	public void receive() {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];
						int length = in.read(buffer);
						if(length == -1) throw new IOException(); // 읽어오는 데 오류가 있으면 예외 발생시키기
						System.out.println("[메세지 수신 성공] " 
									+ socket.getRemoteSocketAddress()
									+ " : " + Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8"); // 한글도 읽어올 수 있도록 UTF-8로 인코딩까지
						System.out.println("수신 : " + message);
						// 클라이언트가 메세지를 받으면 다른 클라이언트들에게도 메세지 전송
						for(ServerThread serverThread : ServerMain.clients) {
							serverThread.send(message);
						}
					}
				} catch(Exception e) {
					try {
						System.out.println("[메세지 수신 오류] "
								+ socket.getRemoteSocketAddress()
								+ " : " + Thread.currentThread().getName());
					} catch(Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		};
		ServerMain.threadPool.submit(thread); // main 클래스의 threadPool에 해당 스레드 적용
	}
	
	// 클라이언트에게 메세지를 전송하는 메서드 (서버 스레드)
	public void send(String message) {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				try {
					OutputStream out = socket.getOutputStream();
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer);
					out.flush();
					System.out.println("송신 : " + message);
					System.out.println("[메세지 송신 성공] " 
							+ socket.getRemoteSocketAddress()
							+ " : " + Thread.currentThread().getName());
				} catch(Exception e) {
					try {
						System.out.println("[메세지 송신 오류]"
								+ socket.getRemoteSocketAddress()
								+ " : " + Thread.currentThread().getName());
						ServerMain.clients.remove(ServerThread.this); // 서버와 접속이 끊긴 클라이언트 제거
						socket.close(); // 소켓 닫기
					} catch(Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		};
		ServerMain.threadPool.submit(thread);
	}
}
