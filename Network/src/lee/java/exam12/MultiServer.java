package lee.java.exam12;
import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	private ArrayList<MultiServerThread> list;
	private Socket socket;

	
	public MultiServer() throws IOException {
		System.out.println("[서버]");
		list = new ArrayList<MultiServerThread>();
		ServerSocket server = new ServerSocket(5000);
		System.out.println("#서버 준비");
		MultiServerThread serverThread = null;
		boolean isStop = false;
		
		while(!isStop) {
			socket = server.accept();
			serverThread = new MultiServerThread(this);
			list.add(serverThread);
			Thread thread = new Thread(serverThread);
			thread.start();		
		}
	}
	
	public ArrayList<MultiServerThread> getList() {
		return list;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public static void main(String[] args) throws IOException {
		new MultiServer();
	}
}
