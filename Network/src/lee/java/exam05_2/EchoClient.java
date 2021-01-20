package lee.java.exam05_2;
import java.io.*;
import java.net.*;

public class EchoClient {
	public EchoClient() {
		System.out.println("[클라이언트]");
		try {

 			Socket socket = new Socket("localhost", 5000);
 			
 			
 			OutputStream os = socket.getOutputStream();
 			InputStream is = socket.getInputStream();
 			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
 			BufferedReader br = new BufferedReader(new InputStreamReader(is));
 			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 부터 입력
 			
 			while(true) {
            System.out.print("전송할 메세지 : ");
            String message = keyboard.readLine(); 
            
            bw.write(message + "\n"); 
            bw.flush();
 			
			String response = br.readLine();
 			System.out.println("[서버 메세지]" + response);
 			}
		} catch(UnknownHostException e) {
			System.err.println("서버를 찾을 수 없습니다.");
		} catch(IOException e) {
			System.err.println("해당 포트가 사용중이거나 존재하지 않습니다.");
		}
	}
	
	public static void main(String[] args) {
		new EchoClient();
	}
}
