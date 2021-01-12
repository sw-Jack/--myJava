package lee.java.exam04;
import java.io.IOException;
import java.net.*;

public class ServerSocketEx {
	public static void main(String[] args) {
		System.out.println("[서버]");
		try {
			// 클라이언트를 받아들이기 위한 ServerSocket 생성  -> 포트 : 3000
			ServerSocket server = new ServerSocket(3000);
			System.out.println("#서버 준비 완료");
			while(true) {
				// 서버 소켓 열기 : 접속자가 발생할 때까지 서버는 대기
				Socket socket = server.accept();
				if(socket != null) System.out.println("#클라이언트 접속");
				// 접속한 클라이언트 IP를 알아내기 위한 객체 받기 (클라이언트 객체)
				InetAddress client = socket.getInetAddress();
				String clientIp = client.getHostAddress();
				System.out.println("* " + clientIp + "님 접속");
			}
		} catch(IOException e) { // 서버 포트 예외 처리 : 해당 포트가 사용중이며 IOException
			System.err.println("!Error! 해당 포트가 사용중입니다.");
		}
	}
}
