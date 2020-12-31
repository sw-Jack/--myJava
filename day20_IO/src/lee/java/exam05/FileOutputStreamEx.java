package lee.java.exam05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// FileOutputStream Ȱ�� ����
public class FileOutputStreamEx {
	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;
		try {
			// true�� �̾�� (����Ʈ�� false�� �����)        // ���� ��� �Է� ��
			fileOutputStream = new FileOutputStream("[Input file's full path]", true);
			String message = "Hello FileOutputStream!";
			// str.getBytes() : ���ڿ�(str) -> ����Ʈ �迭
			fileOutputStream.write(message.getBytes());
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileOutputStream != null) fileOutputStream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
