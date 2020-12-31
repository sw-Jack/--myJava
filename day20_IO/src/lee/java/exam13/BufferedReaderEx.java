package lee.java.exam13;
import java.io.*;

// BufferedReader Ȱ�� ���� : �ؽ�Ʈ�κ��� ���� �о����
public class BufferedReaderEx {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null; // ���� �б� (1��)
		InputStreamReader inputStreamReader = null; // �긴�� ��Ʈ�� (2��)
		BufferedReader bufferedReader = null; // ���� ��Ʈ�� (2��)
		
		try {
			fileInputStream = new FileInputStream("[input file's full path]");
			inputStreamReader = new InputStreamReader(fileInputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			
			// �� ���ξ� �о���� ���ڿ��� ������ ����
			String str = null;
			// readLine() ���� ���ڸ� ������ ���� ���� ���������� ���ڿ��� ������ 
			// ��ȯ�ϰ� ��Ʈ���� ���� �����ϸ� null ��ȯ
			while((str = bufferedReader.readLine()) != null) {
				System.out.println(str);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try { 
				if(bufferedReader != null) 
					bufferedReader.close(); 
			} catch(IOException e) {}
			try { 
				if(inputStreamReader != null) 
					inputStreamReader.close(); 
			} catch(IOException e) {}	
			try { 
				if(fileInputStream != null) 
					fileInputStream.close(); 
			} catch(IOException e) {}
		} 
	}
}
