package lee.java.exam02;

import java.io.File;

public class FileEx2 {
	public static void main(String[] args) {
		File directory = new File("C:\\");
		
		if(directory.exists()) {
			// 현재 디렉토리 내의 모든 파일 디렉토리 이름 얻기
			String[] fileNameList = directory.list();
			for(String fileName : fileNameList) {
				System.out.println("파일 이름 : " + fileName);
			}
		}
	}

}
