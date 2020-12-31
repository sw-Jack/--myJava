package lee.java.exam12;
import java.io.*;

// BufferedWriter Ȱ�� ���� : �ؽ�Ʈ�� ���� ���
public class BufferedWriterEx {
	public static void main(String[] args) {
		// BufferedWriter�� 2�� ��Ʈ���̱� ������ �̸� ������ 1�� ��Ʈ���� �ʿ�
		// 1�� ��Ʈ���� FileWriter�� Ȱ���� ����
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			fileWriter = new FileWriter("[input file's full path]");
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("BufferedWriter �׽�Ʈ");
			bufferedWriter.newLine();
			bufferedWriter.write("�ȳ��ϼ���" 
			+ System.getProperty("line.separator")); // �� ����
			bufferedWriter.write("�ݰ����ϴ�");
			bufferedWriter.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedWriter != null) bufferedWriter.close();
			} catch(IOException e) {}
			try {
				if(fileWriter != null) fileWriter.close();
			} catch(IOException e) {}
		}
	}
}
