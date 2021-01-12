package lee.java.exam02;
import java.io.*;
import java.net.*;

public class URLEx {
	
	
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			URL url = 
				new URL("http://www.kgitbank.com");
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("포트번호 : " + url.getPort());
			System.out.println("경로 : " + url.getPath());
			System.out.println("파일 : " + url.getFile());
			
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
