import java.io.*;

/**
	0 ~ 255 ������ ���ڸ� �������� ��ȯ
*/
	
public class MyExam10 {
	public static void main(String[] args) throws IOException {

		int[] bit = new int[8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("0 ~ 255 ������ ���� �Է� : ");
		int num = Integer.parseInt(br.readLine());

		for(int i=0; i<bit.length; i++) {
			bit[bit.length-i-1] = num % 2;
			num = num / 2;
			if(num == 0) break;
		}

		System.out.print("������ : ");
		for(int i=0; i<bit.length; i++) {
			System.out.print(bit[i]);
			if(i == 3) System.out.print(" ");
		}
		System.out.println();
	}
}
