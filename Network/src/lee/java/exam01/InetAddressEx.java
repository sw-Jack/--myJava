package lee.java.exam01;
import java.net.*;

public class InetAddressEx {

	public static void main(String[] args) {
		try {
			// host �̸��� �ش��ϴ� ip ������ ���� InetAddress ��ü ���
			InetAddress ipInfo = InetAddress.getByName("www.kgitbank.com");
			String ip = ipInfo.getHostAddress();
			System.out.println("ip �ּ� : " + ip);
			
			// host �̸��� �ش��ϴ� ip ������ ���� ��� InetAddress ��ü ���
			InetAddress[] ips = InetAddress.getAllByName("www.kgitbank.com");
			for(InetAddress temp : ips) {
				System.out.println(temp);
			}
			
			// ���� ��ǻ���� ip ������ ���� InetAddress ��ü ���
			InetAddress myHost = InetAddress.getLocalHost();
			System.out.println("host : " + myHost.getHostName());
			System.out.println("host IP : " + myHost.getHostAddress());
			
		} catch(UnknownHostException e) {
			// host �̸��� �ش��ϴ� host�� ã�� ���� ��� 
			e.printStackTrace();
		}
	}
}
