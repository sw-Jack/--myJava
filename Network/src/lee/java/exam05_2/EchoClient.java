package lee.java.exam05_2;
import java.io.*;
import java.net.*;

public class EchoClient {
	public EchoClient() {
		System.out.println("[Ŭ���̾�Ʈ]");
		try {

 			Socket socket = new Socket("localhost", 5000);
 			
 			
 			OutputStream os = socket.getOutputStream();
 			InputStream is = socket.getInputStream();
 			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
 			BufferedReader br = new BufferedReader(new InputStreamReader(is));
 			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // Ű����� ���� �Է�
 			
 			while(true) {
            System.out.print("������ �޼��� : ");
            String message = keyboard.readLine(); 
            
            bw.write(message + "\n"); 
            bw.flush();
 			
			String response = br.readLine();
 			System.out.println("[���� �޼���]" + response);
 			}
		} catch(UnknownHostException e) {
			System.err.println("������ ã�� �� �����ϴ�.");
		} catch(IOException e) {
			System.err.println("�ش� ��Ʈ�� ������̰ų� �������� �ʽ��ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		new EchoClient();
	}
}
