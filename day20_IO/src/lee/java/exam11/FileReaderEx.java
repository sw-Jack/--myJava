package lee.java.exam11;
import java.io.*;

// FileReader Ȱ�� ���� : ���Ϸκ��� �� ���ھ� �ؽ�Ʈ �б�
public class FileReaderEx {
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			// ���Ϸκ��� �� ���� ������ �о� �� �� �ִ� FileReader ��ü ����
			fileReader = new FileReader("[input file's full path]");
			// ��Ʈ���� ���ؼ� �о���� �����ڵ� ���� ������ ����
			int readValue = 0;
			// read() �޼���� ��Ʈ������ ���ڸ� �о�� �����ڵ� ���� ���ڷ� ��ȯ
			// �� �̻� ���� �� ���� �� -1�� ��ȯ
			while((readValue = fileReader.read()) != -1) {
				System.out.print((char)readValue);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileReader != null) fileReader.close();
			} catch(IOException e) {}
		}
	}

}
