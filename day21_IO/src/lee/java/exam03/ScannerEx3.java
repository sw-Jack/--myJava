package lee.java.exam03;
import java.io.IOException;
import java.net.*;
import java.util.*;

// Scanner Ȱ�� ���� : URL�κ��� �о����
public class ScannerEx3 {
	public static void main(String[] args) {
		URLConnection urlCon = null;
		Scanner sc = null;
		
		try {
			urlCon = new URL("http://www.kgitbank.co.kr/").openConnection();
			sc = new Scanner(urlCon.getInputStream());
			sc.useDelimiter("\\Z"); // ������ ������ �б�
			String text = sc.next();
			System.out.println(text);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(sc != null) sc.close();
		}
	}
}
