package lee.java.exam13;
import java.io.*;

// BufferedReader 활용 예제 : 텍스트로부터 문자 읽어오기
public class BufferedReaderEx {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null; // 파일 읽기 (1차)
		InputStreamReader inputStreamReader = null; // 브릿지 스트림 (2차)
		BufferedReader bufferedReader = null; // 버퍼 스트림 (2차)
		
		try {
			fileInputStream = new FileInputStream("[input file's full path]");
			inputStreamReader = new InputStreamReader(fileInputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			
			// 한 라인씩 읽어들인 문자열을 저장할 변수
			String str = null;
			// readLine() 개행 문자를 만나면 개행 문자 이전까지의 문자열을 스스로 
			// 반환하고 스트림의 끝에 도달하면 null 반환
			while((str = bufferedReader.readLine()) != null) {
				System.out.println(str);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try { 
				if(bufferedReader != null) 
					bufferedReader.close(); 
			} catch(IOException e) {}
			try { 
				if(inputStreamReader != null) 
					inputStreamReader.close(); 
			} catch(IOException e) {}	
			try { 
				if(fileInputStream != null) 
					fileInputStream.close(); 
			} catch(IOException e) {}
		} 
	}
}
