package lee.java.exam10;
import java.io.*;
import java.net.*;

public class ProtocolServer {

	ServerSocket server = null;
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public ProtocolServer() throws IOException {
		System.out.println("[서버]");
		server = new ServerSocket(5000);
		System.out.println("#서버 준비");
		socket = server.accept();
		
		bw = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		while(true) {
			String rec = br.readLine();
			String[] words = rec.split(":");
			
			Protocol protocol = new Protocol();
			if(words[0].equals(protocol.ENTER)) {
				// 입장
				enter(words);
			} else if(words[0].equals(protocol.EXIT)) {
				// 퇴장
				exit(words);
			} else if(words[0].equals(protocol.SEND_MESSAGE)) {
				// 메세지 전달
				sendMessage(words);
			} else if(words[0].equals(protocol.SECRET_MESSAGE)) {
				// 귓속말
				sendSecretMessage(words);
			} else {
				bw.write("잘못된 요청입니다.");
				bw.flush();
			}
		}
	}	
	
	public void enter(String[] arr) throws IOException {
		// 100:아이디 
		System.out.println(arr[1] + "님이 입장하셨습니다.");
		bw.write(arr[1] + "님이 입장하셨습니다.\n");
		bw.flush();
	}
	
	public void exit(String[] arr) throws IOException {
		// 200:아이디
		System.out.println(arr[1] + "님이 퇴장하셨습니다.");
		bw.write(arr[1] + "님이 퇴장하셨습니다.\n");
		bw.flush();
	}
	
	public void sendMessage(String[] arr) throws IOException {
		// 300:아이디:메세지
		System.out.println("[" + arr[1] + "] " + arr[2]);
		bw.write("[" + arr[1] + "] " + arr[2] + "\n");
		bw.flush();
	}
	
	public void sendSecretMessage(String[] arr) throws IOException {
		System.out.println("<" + arr[1] + ">" + arr[3]);
		bw.write("<" + arr[1] + ">" + arr[3] + "\n");
		bw.flush();
	}

	public static void main(String[] args) {
		try {
			new ProtocolServer();
		} catch(IOException e) {}
	}
}
