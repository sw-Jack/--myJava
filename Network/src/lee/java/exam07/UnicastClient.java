package lee.java.exam07;
import java.io.*;
import java.net.*;

public class UnicastClient {
	Socket socket = null;
	BufferedReader clientInput = null; 
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public UnicastClient() {
		System.out.println("[클라이언트]");
		try {
			socket = new Socket("localhost", 5000);
		} catch(UnknownHostException e) {
			System.err.println("해당 서버를 찾을 수 없습니다.");
			System.exit(0);
		} catch(IOException e) {
			System.err.println("해당 포트가 이미 사용중이거나 서버와 연결할 수 없습니다.");
			System.exit(0);
		}
		System.out.println("#서버 접속 완료\n");
		try {
			clientInput = new BufferedReader(
					new InputStreamReader(System.in));
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				// 메세지 송신
				System.out.print("#메세지 입력 : ");
				String send = clientInput.readLine();
				bw.write(send + "\n");
				bw.flush();
				
				// 메세지 수신
				String rec = br.readLine();
				System.out.println("[서버 메세지] " + rec);
			}
		} catch(IOException e) {
			System.err.println("서버와 연결이 끊어졌습니다.");
		}
	}
	
	public static void main(String[] args) {
		new UnicastClient();
	}
}
