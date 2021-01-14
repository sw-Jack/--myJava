package lee.java.exam09;
import java.io.*;
import java.net.*;

public class ObjectClient {

	public ObjectClient() {
		try {
			Socket socket = new Socket("localhost", 5000);
			
			ObjectOutputStream oos = 
					new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = 
					new ObjectInputStream(socket.getInputStream());
			
			// 클라이언트 정보 입력을 위한 MyMember 객체 생성
			MyMember member = new MyMember();
			member.setId("이것이자바냐");
			member.setPwd("java1234");
			
			// 입력한 클라이언트 정보 객체를 서버로 전송
			oos.writeObject(member);
			
			// 서버 메세지 수신
			String rec = (String)ois.readObject();
			System.out.println(rec);
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ObjectClient();
	}
}
