package lee.java.exam01;
import java.io.File;

public class FileEx1 {
	public static void main(String[] args) {
		                      // ���� ��� �Է� ��
		File file = new File("[input file's full path]");
		System.out.println("���� ���� : " + file.isFile());
		System.out.println("���丮 ���� : " + file.isDirectory());
		System.out.println("��� ��� : " + file.getPath());
		System.out.println("���� ��� : " + file.getAbsolutePath());
		System.out.println("���丮 Ȥ�� ������ �̸� : " + file.getName());
		System.out.println("������ ���� : " + file.length());
		System.out.println("������ ���� ���� ��¥ : " + file.lastModified());
	}
}
