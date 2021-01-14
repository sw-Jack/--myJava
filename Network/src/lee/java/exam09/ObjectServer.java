package lee.java.exam09;
import java.io.*;
import java.net.*;

public class ObjectServer {
	
	public ObjectServer() {
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("[서버 준비]");
			 
			Socket socket = server.accept(); // 클라이언트 접속 전까지 서버 대기
			
			// 클라이언트 접속
			System.out.println("[클라이언트 연결]");
			System.out.println("[client : " + socket.getInetAddress() + "]");
			// 클라이언트-서버간의 소켓을 담은 송수신 스트림
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			// 객체 송수신 스트림
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// 클라이언트로 부터 객체(MyMember 형) 수신
			MyMember clientMember = (MyMember)ois.readObject();
			System.out.println("[클라이언트 정보]");
			System.out.println("- 아이디    : " + clientMember.getId());
			System.out.println("- 비밀번호 : " + clientMember.getPwd());
			
			// 클라이언트에게 메세지 송신
			oos.writeObject("[from.서버] " + clientMember.getId() + "님 환영합니다^^");
		}  catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ObjectServer();
	}
}
