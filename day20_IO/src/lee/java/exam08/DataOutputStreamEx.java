package lee.java.exam08;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DataOutputStream 예제 : 여러 가지 자료형의 데이터를 자료형 대로 파일에 기록
// /DataInputStream & DataOutputStream : 2차 스트림
public class DataOutputStreamEx {
	public static void main(String[] args) {
		// DataOutputStream은 기본 자료형 타입 그대로 스트림을 통해 기록
		// DataOutputStream은 2차 스트림이기 때문에 다른 스트림(1차)을 이용해 특정 Device와 연결
		FileOutputStream fileOutputStream = null; // 1차 스트림 
		DataOutputStream dataOutputStream = null; // 2차 스트림
		
		try {
			// DataOutputStream과 연결된 FileOutputStream 객체 생성
			fileOutputStream = new FileOutputStream("[Input file's full path]");
			// 기본 자료형 그대로 유지할 수 있는 DataOutputStream 객체 생성
			dataOutputStream = new DataOutputStream(fileOutputStream);
			// 작성할 데이터들
			int i = 10;
			double d = 3.14;
			String str = "JAVA 프로그래밍";
			
			// DataOutputStream은 기본 자료형 별로 write 메서드가 별개로 존재
			dataOutputStream.writeInt(i); // 정수형
			dataOutputStream.writeDouble(d); // 실수형
			dataOutputStream.writeUTF(str); // 문자열형
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dataOutputStream != null) dataOutputStream.close();
			} catch(IOException e) {}
			try {
				if(fileOutputStream != null) fileOutputStream.close();
			} catch(IOException e) {}
		}
	}

}
