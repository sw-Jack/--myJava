package lee.java.exam06;
import java.io.*;

// 파일 복사 예제1 : 1byte씩(단위로) 복사
public class FileCopyEx1 {
	public static void main(String[] args) {
		System.out.println("파일복사 시작...");
		long startTime = System.currentTimeMillis();
		FileInputStream src = null; // 복사할 원본이 있는 곳
		FileOutputStream dest = null; // 복사 시킬 곳
		try {
			// 원본 파일을 읽기 위한 FileInputStream 객체 생성
			src = new FileInputStream(new File("[Input source's full path]"));
			// 복사본 파일을 생성하기 위한 FileOutputStream 객체 생성
			dest = new FileOutputStream(new File("[Input destination's full path]"));
			// FileInputStream을 통해서 읽어들인 값을 저장할 변수
			int readValue = 0;
			// FileInputStream의 read() 메서드를 통해서 읽어들인 값을 
			// readValue에 저장 // read()는 스트림 끝에 도착하면 -1을 반환
			while((readValue = src.read()) != -1) {
				// readValue에 저장된 값을 FileOutputStream의 write() 메서드를 통해 파일에 기록
				dest.write(readValue);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dest != null) {
					dest.close();
				}
			} catch(IOException e) {}
			try {
				if(src != null) {
					src.close();
				}
			} catch(IOException e) {}
		}
		long endTime = System.currentTimeMillis();
		long copyTime = endTime - startTime;
		System.out.println("총 소요 시간 : " + copyTime + "ms (" + copyTime/1000 + "s)");
	}

}
