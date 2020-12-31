package lee.java.exam04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// FileInputStream 활용 예제
public class FileInputStreamEx {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		byte reading[] = new byte[100];
		byte console[] = new byte[100];
		
		try {
			System.out.print("파일명 : ");
			System.in.read(console);
			String file = new String(console).trim();
			
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(reading, 0, reading.length);
			System.out.println(new String(reading).trim());
		} catch(FileNotFoundException e) {// 경로명이 잘못된 경우
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileInputStream != null) fileInputStream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
