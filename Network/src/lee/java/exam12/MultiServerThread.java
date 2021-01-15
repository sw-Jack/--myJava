package lee.java.exam12;
import java.io.*;
import java.net.*;

public class MultiServerThread extends Thread {
	private Socket socket;
	private MultiServer multiServer;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public MultiServerThread(MultiServer multiServer) {
		this.multiServer = multiServer;
	}
	
	public synchronized void run() {
		boolean isStop = false;
		try {
			socket = multiServer.getSocket();
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			String recMessage = null;
			while(!isStop) {
				recMessage = (String)ois.readObject();
				String[] str = recMessage.split("#");
				if(str[1].equals("exit")) {
					broadCasting(recMessage);
					isStop = true;
				} else 
					broadCasting(recMessage);
			}
			// 나가려는 상태
			multiServer.getList().remove(this);
			System.out.println(socket.getInetAddress() + 
										" 정상적으로 종료하셨습니다.");
			System.out.println("list size : " + 
									multiServer.getList().size());
		} catch(Exception e) {
			multiServer.getList().remove(this);
			System.out.println(socket.getInetAddress() + 
										" 비정상적으로 종료하셨습니다.");	
			System.out.println("list size : " + 
									multiServer.getList().size());
		} 
	}	
	
	public void broadCasting(String message) throws IOException {
		for(MultiServerThread mst : multiServer.getList()) {
			mst.send(message);
		}
	}
	
	public void send(String message) throws IOException {
		oos.writeObject(message);
	}
}
