package lee.java.exam10;
import java.io.*;

// FileWriter Ȱ�� ���� : ���Ͽ� �ؽ�Ʈ ���
public class FileWriterEx {
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		try {
			// ���Ͽ� �� ���� ������ ����� �� �ִ� FileWriter ��ü ����
			fileWriter = new FileWriter("[input file's full path]");
			// writer�� ���ڿ��� �ٷ� ���
			String str = "�б� ���� ������ � ������";
			fileWriter.write(str);
			// �� ���� ������ �а� ���� �ִ� Reader, Writer �迭�� ��Ʈ���� 
			// �⺻������ ���۸� �����ϰ� ����
			// ����Ǿ� �ִ� ���۴� ���۰� ���� ä���� ������ ��Ʈ���� ���� ������
			// flush()�� ���۰� �������� �ʾƵ� ���� ��
			fileWriter.flush();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally { 
			try {
				if(fileWriter != null) fileWriter.close();
			} catch(IOException e) {}
		}
	}

}
