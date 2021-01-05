package lee.java.exam02;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

// Scanner 활용 예제 : 파일로부터 읽어오기
public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(new File("[input file's path]")));
			while(sc.hasNextDouble()) {
				System.out.printf("스캔된 double :  %,.2f %n",
						sc.nextDouble());
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(sc != null) sc.close();
		}
	}
}

