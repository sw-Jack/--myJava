import java.io.*;

// �ҹ��� / �빮�� ��ȯ ����
public class Test03_19 { 
	public static void main(String[] args) throws IOException {
		System.out.print("���ĺ� �Է� : ");
		char alpha = (char) System.in.read(); // 1byte -> 2byte

		// �빮�� : 65 ~ 90, �ҹ��� : 97 ~ 122 => ���� : 32
		if(alpha >= 65 &&  alpha <= 90) { // �빮�� -> �ҹ���
			alpha += 32;
		} else { // �ҹ��� -> �빮��
			alpha -= 32;
		}

		System.out.println("��ȯ �� ���� : " + alpha);
	}
}
