package lee.java.exam05;
import java.io.*;

// ObjectOutputStream : ��ü ����ȭ
public class ObjectOutputStreamEx {
	public static void main(String[] args) {
		ObjectOutputStream objectOutputStream = null;
		try {
			// �޸𸮿� ������ ��ü�� ����ȭ�ؼ� ��Ʈ���� ���� ����� �� �ִ� 
			// ObjectOutputStream ��ü ����
			objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("[input file's path]"));
			// ObjectOutputStream�� ���� ����ȭ�� �� ���Ϸ� ��ϵ� Data
			// ��ü ���� Data Ŭ������ �ݵ�� serializable�� �����ϰ� �־�� ��
			Data data = new Data();
			data.setNo(33);
			data.setName("ȫ�浿");
			data.setMail("hongil@nate.com");
			// ObjectOutputStream�� ��ü�� ����ȭ�ؼ� ��Ʈ���� ���� ����� �� �ִ�
			// writeObject() �޼��带 ������
			objectOutputStream.writeObject(data); // ����ȭ & write
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(objectOutputStream != null) objectOutputStream.close();
			} catch(IOException e) {}
		}
	}
}
