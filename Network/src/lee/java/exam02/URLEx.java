package lee.java.exam02;
import java.io.*;
import java.net.*;

public class URLEx {
	
	
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			URL url = 
				new URL("http://www.kgitbank.com");
			System.out.println("�������� : " + url.getProtocol());
			System.out.println("ȣ��Ʈ : " + url.getHost());
			System.out.println("��Ʈ��ȣ : " + url.getPort());
			System.out.println("��� : " + url.getPath());
			System.out.println("���� : " + url.getFile());
			
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = null;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try { if(br != null) br.close(); } catch(IOException e) {}
		}
	}
}
