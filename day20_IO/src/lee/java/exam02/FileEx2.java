package lee.java.exam02;

import java.io.File;

public class FileEx2 {
	public static void main(String[] args) {
		File directory = new File("C:\\");
		
		if(directory.exists()) {
			// ���� ���丮 ���� ��� ���� ���丮 �̸� ���
			String[] fileNameList = directory.list();
			for(String fileName : fileNameList) {
				System.out.println("���� �̸� : " + fileName);
			}
		}
	}

}
