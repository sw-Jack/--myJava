package lee.java.exam12;
import java.io.*;

// BufferedWriter 활용 예제 : 텍스트에 문자 기록
public class BufferedWriterEx {
	public static void main(String[] args) {
		// BufferedWriter는 2차 스트림이기 때문에 이를 받쳐줄 1차 스트림이 필요
		// 1차 스트림인 FileWriter을 활용해 연결
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			fileWriter = new FileWriter("[input file's full path]");
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("BufferedWriter 테스트");
			bufferedWriter.newLine();
			bufferedWriter.write("안녕하세요" 
			+ System.getProperty("line.separator")); // 줄 개행
			bufferedWriter.write("반갑습니다");
			bufferedWriter.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedWriter != null) bufferedWriter.close();
			} catch(IOException e) {}
			try {
				if(fileWriter != null) fileWriter.close();
			} catch(IOException e) {}
		}
	}
}
