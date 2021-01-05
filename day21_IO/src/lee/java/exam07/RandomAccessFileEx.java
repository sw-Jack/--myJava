package lee.java.exam07;
import java.io.*;

// RandomAccessFile Ȱ�� ����
public class RandomAccessFileEx {
	public static void main(String[] args) {
		RandomAccessFile ra = null;
		 try {
			 ra = new RandomAccessFile("[input file's path]", "rw");
			 String receive = "hello";
			 ra.seek(ra.length());
			 ra.write(receive.getBytes());
			 byte[] buffer = new byte[(int)ra.length()];
			 ra.seek(0);
			 ra.read(buffer);
			 System.out.print("ó�� ���� ���� : ");
			 System.out.println(new String(buffer));
			 ra.seek(0);
			 ra.read(buffer);
			 System.out.print("�ٽ� ���� ���� : ");
			 System.out.println(new String(buffer));
		 } catch(IOException e) {
			 e.printStackTrace();
		 } finally {
			try {
				if(ra != null) ra.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
