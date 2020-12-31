package lee.java.exam14;
import java.io.*;

// PrintStream 활용 예제 : 파일에 문자 기록하기
public class PrintStreamEx {
	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		PrintStream printStream = null;
		try {
			fileOutputStream = new FileOutputStream("[input file's full path]");
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			printStream = new PrintStream(bufferedOutputStream);
			printStream.println("홍길동");
			printStream.println(1234);
			printStream.println(true);
			printStream.println('A');
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(printStream != null) 
				printStream.close();
			try {
				if(bufferedOutputStream != null) 
					bufferedOutputStream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			try {
				if(fileOutputStream != null) 
					fileOutputStream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
