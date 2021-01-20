package lee.java.exam05_1;
import java.io.*;
import java.net.*;
public class EchoServer {

	public EchoServer() {
		System.out.println("[서버]");
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("#서버 가동");

			Socket socket = server.accept();
			System.out.println("#서버 준비 완료");
			
			InetAddress client = socket.getInetAddress();
			String clientIp = client.getHostAddress();
			System.out.println("#[" + clientIp + "] 접속\n");
				
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
 			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 부터 입력
 			while(true) {
				String message = br.readLine();
				System.out.println("[" + clientIp + " 님의 메세지] " + message);
				
	            System.out.print("전송할 메세지 : ");
	            String reply = keyboard.readLine(); 
	            
	            bw.write(reply + "\n"); 
	            bw.flush();
			}
		} catch (IOException e) {
			System.err.println("해당 포트는 사용중입니다.");
		}
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}
}
