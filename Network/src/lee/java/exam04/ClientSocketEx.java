package lee.java.exam04;
import java.io.IOException;
import java.net.*;

public class ClientSocketEx {
	public static void main(String[] args) {
		System.out.println("[클라이언트]");
		// 클라이언트가 서버에 접속
		try {
			Socket socket = new Socket("localhost", 3000);
		} catch (UnknownHostException e) {
			System.err.println("!Error! 해당 주소가 존재하지 않습니다.");
		} catch (IOException e) {
			System.err.println("!Error! 해당 포트가 사용중입니다.");
		}
		System.out.println("#서버 접속");
	}
}
