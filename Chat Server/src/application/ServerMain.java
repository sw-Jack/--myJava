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
	
	// ExecutorService : ���� ���� ��������� ȿ�������� �����ϱ� ���� ����ϴ� ��ǥ�� ���̺귯��
	// -> threadpool���� �������� ���ڿ� ������ �α� ������ ���۽����� Ŭ���̾�Ʈ ���ڰ� �����ϴ���
	//    ������ ���� ���ϸ� ������ �� ���� => ������ �ڿ��� �̿��� ���������� ������ �
	public static ExecutorService threadPool;
	public static Vector<ServerThread> clients = new Vector<ServerThread>();
	
	ServerSocket serverSocket;
	
	// ������ �������Ѽ� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼���
	public void startServer(String ip, int port) {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(ip, port));
		} catch(Exception e) {
			e.printStackTrace();
			if(!serverSocket.isClosed()) { // ���� �߻��� ���� ������ �������� �ʴٸ� ������ �۵��� ������Ŵ
				stopServer();
			}
			return;
		}
		
		// Ŭ���̾�Ʈ�� ������ ������ ��ٸ��� ������
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						// Ŭ���̾�Ʈ ���� ���� �Ʒ� ����
						clients.add(new ServerThread(socket));
						System.out.println("[Ŭ���̾�Ʈ ����]" 
								+ socket.getRemoteSocketAddress()
								+ " : " + Thread.currentThread().getName());
					} catch(Exception e) {
						if(!serverSocket.isClosed()) { // ���� �߻��� ���� ������ �������� �ʴٸ� ������ �۵��� ������Ŵ
							stopServer();
						}
						break;
					}
				}
			}
		};
		threadPool = Executors.newCachedThreadPool(); // ������Ǯ �ʱ�ȭ
		threadPool.submit(thread);
	}
	
	// ������ �۵��� ������Ű�� �޼���
	public void stopServer() {
		try {
			// ���� �۵� ���� ��� ���� �ݱ�
			Iterator<ServerThread> iterator = clients.iterator();
			while(iterator.hasNext()) { // �Ѹ� �Ѹ��� Ŭ���̾�Ʈ�鿡�� ����
				ServerThread serverThread = iterator.next();
				serverThread.socket.close();
				iterator.remove();
			}
			// ���� ���� ��ü �ݱ�
			if(serverSocket != null && !serverSocket.isClosed()) { 
				serverSocket.close();
			}
			// ������ Ǯ ����
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// UI�� �����ϰ�, ���������� ���α׷��� ���۽�Ű�� �޼���
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("�������", 15));
		root.setCenter(textArea);
		
		Button toggleButton = new Button("�����ϱ�"); // toggleButton�� ��ư �� ������ ������ �� ����
		toggleButton.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setMargin(toggleButton, new Insets(1, 0, 0, 0));
		root.setBottom(toggleButton);
		
		String ip = "127.0.0.1";
		int port = 9876;
		
		// toggleButton�� ������ ���� event
		toggleButton.setOnAction(event -> {
			if(toggleButton.getText().equals("�����ϱ�")) {
				startServer(ip, port);
				Platform.runLater(() -> {
					String message = String.format("[���� ����]\n", ip, port);
					textArea.appendText(message);
					toggleButton.setText("�����ϱ�");
				});
			} else { // �����ϱ� ��ư�� ������ ��
				stopServer();
				Platform.runLater(() -> {
					String message = String.format("[���� ����]\n", ip, port);
					textArea.appendText(message);
					toggleButton.setText("�����ϱ�");
				});
			}
		});
		
		// �ػ� ���� 
		Scene scene = new Scene(root, 400, 400);
		
		primaryStage.setTitle("[ä�� ����]");
		primaryStage.setOnCloseRequest(event -> stopServer()); // X ��ư�� ������ �� 
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// ���α׷��� ������(������)
	public static void main(String[] args) {
		launch(args);
	}
}
