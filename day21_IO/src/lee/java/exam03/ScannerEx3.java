package lee.java.exam03;
import java.io.IOException;
import java.net.*;
import java.util.*;

// Scanner 활용 예제 : URL로부터 읽어오기
public class ScannerEx3 {
	public static void main(String[] args) {
		URLConnection urlCon = null;
		Scanner sc = null;
		
		try {
			urlCon = new URL("http://www.kgitbank.co.kr/").openConnection();
			sc = new Scanner(urlCon.getInputStream());
			sc.useDelimiter("\\Z"); // 파일의 끝까지 읽기
			String text = sc.next();
			System.out.println(text);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(sc != null) sc.close();
		}
	}
}
