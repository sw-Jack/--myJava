package lee.java.exam01;
import java.net.*;

public class InetAddressEx {

	public static void main(String[] args) {
		try {
			// host 이름에 해당하는 ip 정보를 가진 InetAddress 객체 얻기
			InetAddress ipInfo = InetAddress.getByName("www.kgitbank.com");
			String ip = ipInfo.getHostAddress();
			System.out.println("ip 주소 : " + ip);
			
			// host 이름에 해당하는 ip 정보를 가진 모든 InetAddress 객체 얻기
			InetAddress[] ips = InetAddress.getAllByName("www.kgitbank.com");
			for(InetAddress temp : ips) {
				System.out.println(temp);
			}
			
			// 현재 컴퓨터의 ip 정보를 가진 InetAddress 객체 얻기
			InetAddress myHost = InetAddress.getLocalHost();
			System.out.println("host : " + myHost.getHostName());
			System.out.println("host IP : " + myHost.getHostAddress());
			
		} catch(UnknownHostException e) {
			// host 이름에 해당하는 host를 찾지 못한 경우 
			e.printStackTrace();
		}
	}
}
