package lee.java.exam05;
import java.io.*;

// ObjectInputStream : ��ü ������ȭ(���Ͽ��� ��������)
public class ObjectInputStreamEx {
	public static void main(String[] args) {
		ObjectInputStream objectInputStream = null;
		 try {
			 // ���Ͽ� ����� ��ü�� �о���̱� ���� ObjectInputStream ��ü ����
			 objectInputStream = new ObjectInputStream(
					 new FileInputStream("[input file's path]"));
			 // ObjectInputStream�� ��Ʈ�����κ��� �о���� ����ȭ�� ��ü��
			 // ������ȭ�Ͽ� ��ü�� ������� �� �ִ�.
			 // ������ȭ�� �� �ʿ��� Ŭ���� ������ ã�� ���� ��� ClassNotFoundException
			 Data data = (Data)objectInputStream.readObject(); // ������ȭ
			 System.out.println("��ȣ : " + data.getNo());
			 System.out.println("�̸� : " + data.getName());
			 System.out.println("���� : " + data.getMail());
		 } catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 } catch(FileNotFoundException e) {
			 e.printStackTrace();
		 } catch(IOException e) {
			 e.printStackTrace();
		 } finally {
			 try {
				 if(objectInputStream != null) objectInputStream.close();
			 } catch(IOException e) {}
		 }
	}
}
