package lee.java.exam03;

import java.io.File;
import java.io.IOException;

public class FileEx3 {
	public static void main(String[] args) throws IOException {
		// 파일 생성
		File file1 = new File("C:\\"); // 빈 파일이 만들어짐
		if(file1.exists()) {
			System.out.println("파일 이름 : " + file1.getName());
		} else {
			//IOException 발생
			if(file1.createNewFile()) {
				System.out.println("새로운 파일이 생성되었습니다");
			}
		}
		
		// 디렉토리 생성
		File file2 = new File("C:\\newDirectory");
		if(!file2.exists()) {
			file2.mkdir();
		} else {
			System.out.println("디렉토리 이름 : " + file2.getPath());
		}
		
		// 파일 혹은 디렉토리 삭제
		File file3 = new File("C:\\text.txt");
		if(file3.exists()) {
			file3.delete();
		}
		
		// 파일 혹은 디렉토리 이름 변경
		File src = new File("C:\\newFile.txt");
		File dest1 = new File("C:\\newDirectory\\dest1.txt");
		File dest2 = new File("C:\\newDirectory\\dest2.txt");

		if(src.exists()) {
			src.renameTo(dest1);
			src.renameTo(dest2);
		}
		if(file2.isDirectory()) { // 디렉토리 목록을 출력
			String dir[] = file2.list();
			System.out.println("\n\n Dir Contents===================\n");
			for(String dirs : dir) {
				System.out.println("dirs : " + dirs);
			}
		}
	}
}
