package lee.java.exam11;
import java.io.*;
import java.net.*;

public class UDPEchoServer {
	
	public UDPEchoServer(int port) {
		System.out.println("[서버]");
		try {
			DatagramSocket ds = new DatagramSocket(port);
			System.out.println("#서버 준비");
			while(true) {
				byte buffer[] = new byte[512];
				DatagramPacket dp = 
						new DatagramPacket(buffer, buffer.length);
				ds.receive(dp); // 소켓은 꽂아놓고 패킷을 왔다갔다
				String str = new String(dp.getData());
				System.out.println("수신된 데이터 : " + str);
				InetAddress client = dp.getAddress();
				port = dp.getPort();
				System.out.println("client ip : " + client + 
									", client port : " + port);
				dp = new DatagramPacket(dp.getData(), 
											dp.getData().length, client, port);
				ds.send(dp);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UDPEchoServer(3000);
	}
}
