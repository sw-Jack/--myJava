package lee.java.exam08;
import java.io.*;

public class MulticastClientThread extends Thread {
	private BufferedReader br;
	
	public MulticastClientThread(BufferedReader br) {
		this.br = br;
	}
	
	public void run() {
		try {
			while(true) {
				// 서버가 전송한 메세지 읽기
				String rec = br.readLine();
				System.out.println(rec);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
