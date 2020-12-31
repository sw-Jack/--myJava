package lee.java.exam11;
import java.io.*;

// FileReader 활용 예제 : 파일로부터 한 문자씩 텍스트 읽기
public class FileReaderEx {
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			// 파일로부터 한 문자 단위로 읽어 올 수 있는 FileReader 객체 생성
			fileReader = new FileReader("[input file's full path]");
			// 스트림을 통해서 읽어들인 유니코드 값을 저장할 변수
			int readValue = 0;
			// read() 메서드는 스트림에서 문자를 읽어와 유니코드 값을 숫자로 반환
			// 더 이상 읽을 수 없을 때 -1을 반환
			while((readValue = fileReader.read()) != -1) {
				System.out.print((char)readValue);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileReader != null) fileReader.close();
			} catch(IOException e) {}
		}
	}

}
