package lee.java.exam05;
import java.io.*;

// ObjectInputStream : 객체 역직렬화(파일에서 가져오기)
public class ObjectInputStreamEx {
	public static void main(String[] args) {
		ObjectInputStream objectInputStream = null;
		 try {
			 // 파일에 저장된 객체를 읽어들이기 위해 ObjectInputStream 객체 생성
			 objectInputStream = new ObjectInputStream(
					 new FileInputStream("[input file's path]"));
			 // ObjectInputStream은 스트림으로부터 읽어들인 직렬화된 객체를
			 // 역직렬화하여 객체를 재생성할 수 있다.
			 // 역직렬화할 때 필요한 클래스 파일을 찾지 못할 경우 ClassNotFoundException
			 Data data = (Data)objectInputStream.readObject(); // 역직렬화
			 System.out.println("번호 : " + data.getNo());
			 System.out.println("이름 : " + data.getName());
			 System.out.println("메일 : " + data.getMail());
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
