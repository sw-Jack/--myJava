package lee.java.exam11;
import java.io.*;
import java.net.*;

public class UDPEchoServer {
	
	public UDPEchoServer(int port) {
		System.out.println("[����]");
		try {
			DatagramSocket ds = new DatagramSocket(port);
			System.out.println("#���� �غ�");
			while(true) {
				byte buffer[] = new byte[512];
				DatagramPacket dp = 
						new DatagramPacket(buffer, buffer.length);
				ds.receive(dp); // ������ �ȾƳ��� ��Ŷ�� �Դٰ���
				String str = new String(dp.getData());
				System.out.println("���ŵ� ������ : " + str);
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
