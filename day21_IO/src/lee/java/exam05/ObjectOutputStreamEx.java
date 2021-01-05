package lee.java.exam05;
import java.io.*;

// ObjectOutputStream : 객체 직렬화
public class ObjectOutputStreamEx {
	public static void main(String[] args) {
		ObjectOutputStream objectOutputStream = null;
		try {
			// 메모리에 생성된 객체를 직렬화해서 스트림을 통해 기록할 수 있는 
			// ObjectOutputStream 객체 생성
			objectOutputStream = new ObjectOutputStream(
					new FileOutputStream("[input file's path]"));
			// ObjectOutputStream을 통해 직렬화된 후 파일로 기록될 Data
			// 객체 생성 Data 클래스는 반드시 serializable을 구현하고 있어야 함
			Data data = new Data();
			data.setNo(33);
			data.setName("홍길동");
			data.setMail("hongil@nate.com");
			// ObjectOutputStream은 객체를 직렬화해서 스트림을 통해 기록할 수 있는
			// writeObject() 메서드를 제공함
			objectOutputStream.writeObject(data); // 직렬화 & write
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
