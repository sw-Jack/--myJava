import java.io.*;
public class InputEx3 {
	public static void main(String[] args) throws IOException {
		String name;
		String age;
		String addr;
		String phone;

		// 1byte 짜리를 2byte로 입력받을게요
		InputStreamReader is = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(is);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("이름 : ");
		name = br.readLine();
		System.out.print("나이 : ");
		age = br.readLine();
		System.out.print("주소 : ");
		addr = br.readLine();
		System.out.print("전화번호 : ");
		phone = br.readLine();

		System.out.println();
		System.out.println(name + "씨");
		System.out.println(age + "세 시네요.");
		System.out.println(addr + "에 사시는 군요.");
		System.out.println(phone + "으로 전화드릴게요~^^");

	}
}
