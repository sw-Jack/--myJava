package lee.java.exam08;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DataOutputStream ���� : ���� ���� �ڷ����� �����͸� �ڷ��� ��� ���Ͽ� ���
// /DataInputStream & DataOutputStream : 2�� ��Ʈ��
public class DataOutputStreamEx {
	public static void main(String[] args) {
		// DataOutputStream�� �⺻ �ڷ��� Ÿ�� �״�� ��Ʈ���� ���� ���
		// DataOutputStream�� 2�� ��Ʈ���̱� ������ �ٸ� ��Ʈ��(1��)�� �̿��� Ư�� Device�� ����
		FileOutputStream fileOutputStream = null; // 1�� ��Ʈ�� 
		DataOutputStream dataOutputStream = null; // 2�� ��Ʈ��
		
		try {
			// DataOutputStream�� ����� FileOutputStream ��ü ����
			fileOutputStream = new FileOutputStream("[Input file's full path]");
			// �⺻ �ڷ��� �״�� ������ �� �ִ� DataOutputStream ��ü ����
			dataOutputStream = new DataOutputStream(fileOutputStream);
			// �ۼ��� �����͵�
			int i = 10;
			double d = 3.14;
			String str = "JAVA ���α׷���";
			
			// DataOutputStream�� �⺻ �ڷ��� ���� write �޼��尡 ������ ����
			dataOutputStream.writeInt(i); // ������
			dataOutputStream.writeDouble(d); // �Ǽ���
			dataOutputStream.writeUTF(str); // ���ڿ���
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dataOutputStream != null) dataOutputStream.close();
			} catch(IOException e) {}
			try {
				if(fileOutputStream != null) fileOutputStream.close();
			} catch(IOException e) {}
		}
	}

}
