// Map �������̽� - HashMap
import java.util.*;
public class MapEx {
	public static void main(String[] args) {
		String[] msg = {"Berlin","Dortmund","Frankfurt","Hamburg","Gelsenkirchen"};
		HashMap<Integer,String> map = new HashMap<Integer,String>(); // HashMap ����

		for(int i=0; i<msg.length; i++)
			map.put(i,msg[i]); // �ʿ� msg ������ ����
		Set<Integer> keys = map.keySet(); // map�� Ű������ Set�� key�� ����
		for(Integer n : keys) 
			System.out.println(map.get(n));
	}
}