package lee.java.exam10;
import java.io.*;
import java.net.*;

public class ProtocolClient {
	Socket socket = null;
	BufferedWriter bw = null;
	BufferedReader br = null;
	BufferedReader clientInput = null;
	
	public ProtocolClient() {
		System.out.println("[클라이언트]");
		try {
			socket = new Socket("localhost", 5000);
		} catch(UnknownHostException e) {
			System.err.println("서버를 찾을 수 없습니다.");
			System.exit(0);
		} catch(IOException e) {
			System.err.println("서버와 연결할 수 없습니다.");
			System.exit(0);
		}
		
		try {
			bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			clientInput = new BufferedReader(
					new InputStreamReader(System.in));
			
			while(true) {
				// 메세지 송신
				String send = clientInput.readLine();
				bw.write(send + "\n");
				bw.flush();
				String[] words = send.split(":");
				// 메세지 수신
				String rec = br.readLine();
				System.out.println("[from.서버] " + rec);
				
				Protocol protocol = new Protocol();
				if(words[0].equals(protocol.EXIT)) {
					throw new IOException();
				}
			}
		} catch(IOException e) {
			System.err.println("서버와 연결이 끊어졌습니다.");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new ProtocolClient();
	}
}
