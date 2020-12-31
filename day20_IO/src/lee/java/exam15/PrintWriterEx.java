package lee.java.exam15;
import java.io.*;

// PrintWriter 활용 예제 : 파일에 문자 기록
public class PrintWriterEx {
	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		PrintWriter printWriter = null;
		
		try {
			fileOutputStream = new FileOutputStream("[input file's full path]");
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			printWriter = new PrintWriter(bufferedOutputStream, true);
			
			printWriter.println("안녕하세요");
			printWriter.println("또 만났네요");
			printWriter.println(100.0);
			printWriter.println(new Boolean(true));
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(printWriter != null)
				printWriter.close();
			try {
				if(bufferedOutputStream != null)
					bufferedOutputStream.close();
				if(fileOutputStream != null)
					fileOutputStream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
