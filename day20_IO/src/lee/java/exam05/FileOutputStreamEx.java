package lee.java.exam05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// FileOutputStream 활용 예제
public class FileOutputStreamEx {
	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;
		try {
			// true는 이어쓰기 (디폴트인 false는 덮어쓰기)        // 파일 경로 입력 ↓
			fileOutputStream = new FileOutputStream("[Input file's full path]", true);
			String message = "Hello FileOutputStream!";
			// str.getBytes() : 문자열(str) -> 바이트 배열
			fileOutputStream.write(message.getBytes());
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileOutputStream != null) fileOutputStream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
