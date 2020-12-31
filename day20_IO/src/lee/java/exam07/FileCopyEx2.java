package lee.java.exam07;
import java.io.*;

// ���� ���� ����2 : byte[](����Ʈ �迭), �� Buffer�� �̿��� ����
public class FileCopyEx2 {
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
			// �ӽ� ����ҿ� ����� data�� ��ü ������ ������ ����
			int length = 0;
			// �ӽ� ����ҷ� ���� byte[] �迭 ����
			byte[] buffer = new byte[8*1024]; // �ڹٿ��� Buffer�� �׻� 8KB(8*1024B)
			// inputstream�� ���ؼ� �о���� data�� �ӽ� ����ҿ� �װ� ����� data�� ������ length�� ����
			// read()�� ��Ʈ�� ���� �����ϸ� -1�� ��ȯ
			while((length = src.read(buffer)) != -1) {
				// outputstream�� ���ؼ� �ӽ� ����ҿ� �׿��ִ� data�� length��ŭ ���Ͽ� ���
				dest.write(buffer, 0, length);
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
