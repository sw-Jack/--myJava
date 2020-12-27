// Map 인터페이스 - HashMap
import java.util.*;
public class MapEx {
	public static void main(String[] args) {
		String[] msg = {"Berlin","Dortmund","Frankfurt","Hamburg","Gelsenkirchen"};
		HashMap<Integer,String> map = new HashMap<Integer,String>(); // HashMap 생성

		for(int i=0; i<msg.length; i++)
			map.put(i,msg[i]); // 맵에 msg 데이터 저장
		Set<Integer> keys = map.keySet(); // map의 키값들을 Set의 key에 저장
		for(Integer n : keys) 
			System.out.println(map.get(n));
	}
}