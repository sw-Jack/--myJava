package lee.java.exam09;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;

// DataInputStream 예제 : 특정 자료형의 포맹과 값을 유지한 채로 읽어오기
// /DataInputStream & DataOutputStream : 2차 스트림
public class DataInputStreamEx {
	public static void main(String[] args) {
		// DataInputStream은 기본 자료형 타입 그대로 스트림을 통해 기록
		// DataInputStream은 2차 스트림이기 때문에 다른 스트림(1차)을 이용해 특정 Device와 연결
		FileInputStream fileInputStream = null; // 1차 스트림 
		DataInputStream dataInputStream = null; // 2차 스트림
		
		try {
			fileInputStream = new FileInputStream("[Input file's full path]");
			dataInputStream = new DataInputStream(fileInputStream);
			// DataInputStream은 기본 자료형을 유지한 채로 저장된 값을 읽어들일 수 있는 
			// read() 메서드가 존재
			// 읽어들일 때는 반드시 기록한 순서대로 읽어와야 함
			int i = dataInputStream.readInt();
			double d = dataInputStream.readDouble();
			String str = dataInputStream.readUTF();
			System.out.println("i 값 : " + i);
			System.out.println("d값 : " + d);
			System.out.println("str 값 : " + str);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dataInputStream != null) dataInputStream.close();
			} catch(IOException e) {}
			try {
				if(fileInputStream != null) fileInputStream.close();
			} catch(IOException e) {}
		}
	}

}
