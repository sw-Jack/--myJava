package lee.java.exam10;
import java.io.*;

// FileWriter 활용 예제 : 파일에 텍스트 기록
public class FileWriterEx {
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		try {
			// 파일에 한 문자 단위로 기록할 수 있는 FileWriter 객체 생성
			fileWriter = new FileWriter("[input file's full path]");
			// writer는 문자열을 바로 기록
			String str = "학교 종이 떙땡땡 어서 모이자";
			fileWriter.write(str);
			// 한 글자 단위로 읽고 쓸수 있는 Reader, Writer 계열의 스트림은 
			// 기본적으로 버퍼를 내장하고 있음
			// 내장되어 있는 버퍼는 버퍼가 가득 채워질 때에만 스트림을 통해 내보냄
			// flush()는 버퍼가 가득차지 않아도 비우게 함
			fileWriter.flush();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally { 
			try {
				if(fileWriter != null) fileWriter.close();
			} catch(IOException e) {}
		}
	}

}
