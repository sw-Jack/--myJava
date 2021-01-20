package application;
	
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class ServerMain extends Application {
	
	// ExecutorService : 여러 개의 스레드들을 효율적으로 관리하기 위해 사용하는 대표적 라이브러리
	// -> threadpool에선 스레드의 숫자에 제한을 두기 때문에 갑작스럽게 클라이언트 숫자가 폭증하더라도
	//    서버의 성능 저하를 방지할 수 있음 => 한정된 자원을 이용해 안정적으로 서버를 운영
	public static ExecutorService threadPool;
	public static Vector<ServerThread> clients = new Vector<ServerThread>();
	
	ServerSocket serverSocket;
	
	// 서버를 구동시켜서 클라이언트의 연결을 기다리는 메서드
	public void startServer(String ip, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(ip, port));
		} catch(Exception e) {
			e.printStackTrace();
			if(!serverSocket.isClosed()) { // 오류 발생시 서버 소켓이 닫혀있지 않다면 서버의 작동을 중지시킴
				stopServer();
			}
			return;
		}
		
		// 클라이언트가 접속할 때까지 기다리는 스레드
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						// 클라이언트 접속 이후 아래 실행
						clients.add(new ServerThread(socket));
						System.out.println("[클라이언트 접속]" 
								+ socket.getRemoteSocketAddress()
								+ " : " + Thread.currentThread().getName());
					} catch(Exception e) {
						if(!serverSocket.isClosed()) { // 오류 발생시 서버 소켓이 닫혀있지 않다면 서버의 작동을 중지시킴
							stopServer();
						}
						break;
					}
				}
			}
		};
		threadPool = Executors.newCachedThreadPool(); // 스레드풀 초기화
		threadPool.submit(thread);
	}
	
	// 서버의 작동을 중지시키는 메서드
	public void stopServer() {
		try {
			// 현재 작동 중인 모든 소켓 닫기
			Iterator<ServerThread> iterator = clients.iterator();
			while(iterator.hasNext()) { // 한명 한명의 클라이언트들에게 접근
				ServerThread serverThread = iterator.next();
				serverThread.socket.close();
				iterator.remove();
			}
			// 서버 소켓 객체 닫기
			if(serverSocket != null && !serverSocket.isClosed()) { 
				serverSocket.close();
			}
			// 스레드 풀 종료
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// UI를 생성하고, 실질적으로 프로그램을 동작시키는 메서드
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("나눔고딕", 15));
		root.setCenter(textArea);
		
		Button toggleButton = new Button("시작하기"); // toggleButton은 버튼 내 문구를 수정할 수 있음
		toggleButton.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setMargin(toggleButton, new Insets(1, 0, 0, 0));
		root.setBottom(toggleButton);
		
		String ip = "127.0.0.1";
		int port = 9876;
		
		// toggleButton을 눌렀을 때의 event
		toggleButton.setOnAction(event -> {
			if(toggleButton.getText().equals("시작하기")) {
				startServer(ip, port);
				Platform.runLater(() -> {
					String message = String.format("[서버 시작]\n", ip, port);
					textArea.appendText(message);
					toggleButton.setText("종료하기");
				});
			} else { // 종료하기 버튼을 눌렀을 때
				stopServer();
				Platform.runLater(() -> {
					String message = String.format("[서버 종료]\n", ip, port);
					textArea.appendText(message);
					toggleButton.setText("시작하기");
				});
			}
		});
		
		// 해상도 설정 
		Scene scene = new Scene(root, 400, 400);
		
		primaryStage.setTitle("[채팅 서버]");
		primaryStage.setOnCloseRequest(event -> stopServer()); // X 버튼을 눌렀을 때 
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// 프로그램의 진입점(시작점)
	public static void main(String[] args) {
		launch(args);
	}
}
