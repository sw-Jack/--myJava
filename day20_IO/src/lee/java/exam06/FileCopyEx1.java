package lee.java.exam06;
import java.io.*;

// ���� ���� ����1 : 1byte��(������) ����
public class FileCopyEx1 {
	public static void main(String[] args) {
		System.out.println("���Ϻ��� ����...");
		long startTime = System.currentTimeMillis();
		FileInputStream src = null; // ������ ������ �ִ� ��
		FileOutputStream dest = null; // ���� ��ų ��
		try {
			// ���� ������ �б� ���� FileInputStream ��ü ����
			src = new FileInputStream(new File("[Input source's full path]"));
			// ���纻 ������ �����ϱ� ���� FileOutputStream ��ü ����
			dest = new FileOutputStream(new File("[Input destination's full path]"));
			// FileInputStream�� ���ؼ� �о���� ���� ������ ����
			int readValue = 0;
			// FileInputStream�� read() �޼��带 ���ؼ� �о���� ���� 
			// readValue�� ���� // read()�� ��Ʈ�� ���� �����ϸ� -1�� ��ȯ
			while((readValue = src.read()) != -1) {
				// readValue�� ����� ���� FileOutputStream�� write() �޼��带 ���� ���Ͽ� ���
				dest.write(readValue);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dest != null) {
					dest.close();
				}
			} catch(IOException e) {}
			try {
				if(src != null) {
					src.close();
				}
			} catch(IOException e) {}
		}
		long endTime = System.currentTimeMillis();
		long copyTime = endTime - startTime;
		System.out.println("�� �ҿ� �ð� : " + copyTime + "ms (" + copyTime/1000 + "s)");
	}

}
