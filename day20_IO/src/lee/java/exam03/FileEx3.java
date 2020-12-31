package lee.java.exam03;

import java.io.File;
import java.io.IOException;

public class FileEx3 {
	public static void main(String[] args) throws IOException {
		// ���� ����
		File file1 = new File("C:\\"); // �� ������ �������
		if(file1.exists()) {
			System.out.println("���� �̸� : " + file1.getName());
		} else {
			//IOException �߻�
			if(file1.createNewFile()) {
				System.out.println("���ο� ������ �����Ǿ����ϴ�");
			}
		}
		
		// ���丮 ����
		File file2 = new File("C:\\newDirectory");
		if(!file2.exists()) {
			file2.mkdir();
		} else {
			System.out.println("���丮 �̸� : " + file2.getPath());
		}
		
		// ���� Ȥ�� ���丮 ����
		File file3 = new File("C:\\text.txt");
		if(file3.exists()) {
			file3.delete();
		}
		
		// ���� Ȥ�� ���丮 �̸� ����
		File src = new File("C:\\newFile.txt");
		File dest1 = new File("C:\\newDirectory\\dest1.txt");
		File dest2 = new File("C:\\newDirectory\\dest2.txt");

		if(src.exists()) {
			src.renameTo(dest1);
			src.renameTo(dest2);
		}
		if(file2.isDirectory()) { // ���丮 ����� ���
			String dir[] = file2.list();
			System.out.println("\n\n Dir Contents===================\n");
			for(String dirs : dir) {
				System.out.println("dirs : " + dirs);
			}
		}
	}
}
