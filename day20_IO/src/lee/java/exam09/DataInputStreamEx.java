package lee.java.exam09;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;

// DataInputStream ���� : Ư�� �ڷ����� ���Ͱ� ���� ������ ä�� �о����
// /DataInputStream & DataOutputStream : 2�� ��Ʈ��
public class DataInputStreamEx {
	public static void main(String[] args) {
		// DataInputStream�� �⺻ �ڷ��� Ÿ�� �״�� ��Ʈ���� ���� ���
		// DataInputStream�� 2�� ��Ʈ���̱� ������ �ٸ� ��Ʈ��(1��)�� �̿��� Ư�� Device�� ����
		FileInputStream fileInputStream = null; // 1�� ��Ʈ�� 
		DataInputStream dataInputStream = null; // 2�� ��Ʈ��
		
		try {
			fileInputStream = new FileInputStream("[Input file's full path]");
			dataInputStream = new DataInputStream(fileInputStream);
			// DataInputStream�� �⺻ �ڷ����� ������ ä�� ����� ���� �о���� �� �ִ� 
			// read() �޼��尡 ����
			// �о���� ���� �ݵ�� ����� ������� �о�;� ��
			int i = dataInputStream.readInt();
			double d = dataInputStream.readDouble();
			String str = dataInputStream.readUTF();
			System.out.println("i �� : " + i);
			System.out.println("d�� : " + d);
			System.out.println("str �� : " + str);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dataInputStream != null) dataInputStream.close();
			} catch(IOException e) {}
			try {
				if(fileInputStream != null) fileInputStream.close();
			} catch(IOException e) {}
		}
	}

}
