package lee.java.exam02;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

// Scanner Ȱ�� ���� : ���Ϸκ��� �о����
public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(new File("[input file's path]")));
			while(sc.hasNextDouble()) {
				System.out.printf("��ĵ�� double :  %,.2f %n",
						sc.nextDouble());
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(sc != null) sc.close();
		}
	}
}

