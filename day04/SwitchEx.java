import java.io.*;

public class SwitchEx {
	public static void main(String[] args) throws IOException {
		String name;
		int kor, eng, math, sum;
		float avg;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���� : ");
		kor = Integer.parseInt(br.readLine());
		System.out.print("���� : ");
		eng = Integer.parseInt(br.readLine());
		System.out.print("���� : ");
		math = Integer.parseInt(br.readLine());

		sum = kor + eng + math;
		avg = sum / 3.f;

		System.out.print("����� ������ \"");
		switch((int)(avg/10)) {
		case 10 :
		case 9 :
			System.out.print("A"); break;
		case 8 :
			System.out.print("B"); break;
		case 7 :
			System.out.print("C"); break;
		case 6 :
			System.out.print("D"); break;
		default :
			System.out.print("F"); break;

		}
		System.out.println("\"�Դϴ�.");
	}
}
