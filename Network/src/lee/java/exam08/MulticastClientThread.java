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
				// ������ ������ �޼��� �б�
				String rec = br.readLine();
				System.out.println(rec);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
