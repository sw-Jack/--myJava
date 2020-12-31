package lee.java.exam07;
import java.io.*;

// 파일 복사 예제2 : byte[](바이트 배열), 즉 Buffer를 이용한 복사
public class FileCopyEx2 {
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
			// 임시 저장소에 저장된 data의 전체 개수를 저장할 변수
			int length = 0;
			// 임시 저장소로 사용될 byte[] 배열 선언
			byte[] buffer = new byte[8*1024]; // 자바에서 Buffer는 항상 8KB(8*1024B)
			// inputstream을 통해서 읽어들인 data를 임시 저장소에 쌓고 저장된 data의 개수를 length에 저장
			// read()는 스트림 끝에 도착하면 -1을 반환
			while((length = src.read(buffer)) != -1) {
				// outputstream을 통해서 임시 저장소에 쌓여있는 data를 length만큼 파일에 기록
				dest.write(buffer, 0, length);
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
