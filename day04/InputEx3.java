import java.io.*;
public class InputEx3 {
	public static void main(String[] args) throws IOException {
		String name;
		String age;
		String addr;
		String phone;

		// 1byte ¥���� 2byte�� �Է¹����Կ�
		InputStreamReader is = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(is);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("�̸� : ");
		name = br.readLine();
		System.out.print("���� : ");
		age = br.readLine();
		System.out.print("�ּ� : ");
		addr = br.readLine();
		System.out.print("��ȭ��ȣ : ");
		phone = br.readLine();

		System.out.println();
		System.out.println(name + "��");
		System.out.println(age + "�� �ó׿�.");
		System.out.println(addr + "�� ��ô� ����.");
		System.out.println(phone + "���� ��ȭ�帱�Կ�~^^");

	}
}
