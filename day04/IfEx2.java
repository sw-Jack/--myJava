// ��ȣȭ & ��ȣȭ ����
import java.io.*;
public class IfEx2 {
	public static void main(String[] args) throws IOException {

	char a = 0;
	char b = 0;
	char c = 0;
	int d = 0;
	
	System.out.print("��ȣ�� : ");
	a = (char)System.in.read();
	b = (char)System.in.read();
	c = (char)System.in.read();
	System.in.read(); System.in.read(); // Enter�� ó��

	System.out.print("Ű���� �Է� (1 ~ 3) : ");
	d = System.in.read() - '0';
	System.in.read(); System.in.read();

	/*
	if(d == 1) {
		a += 1; b += 1; c += 1;
	} else if(d == 2) {
		a += 2; b += 2; c += 2;

	} else { 
		System.out.println("Ű���� ����");
		System.exit(0); // ���α׷� ����
	}
	*/
	if(d != 1 && d != 2)  {
		System.out.println("Ű���� ����");
		System.exit(0);
	} else {
		a+=d; b+=d; c+=d;
	}

	System.out.println("����� ��ȣ�� : " + a + b + c);
	System.out.println(); // �۽���

	System.out.print("��ȣȭ Ű���� : "); // ������
	d = System.in.read() - 48;
	if(d != 1 && d != 2 && d != 3)  {
		System.out.println("��ȣȭ ���� �ʰ�");
		System.exit(0);
	}
	a-=d; b-=d; c-=d;
	System.out.println("���۵� ��ȣ�� : " + a + b + c);
	}

}
