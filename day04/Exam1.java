// ���� ���� 
/*
	# ����
	������ ������ �Է¹ް� ������ ����� ���Ѵ�.
	����� �Ҽ��� ��° �ڸ����� ��Ÿ����. ��, ����� �Ҽ� ��° �ڸ����� ��Ÿ����.
	�Ҽ����� ��Ÿ�� �� printf �� Ȱ������ ���� �Ʒ��� ���� �ذ���� �̿��ؼ� ���³���.
	-----------------------------------------------------------------
	# ���� �ذ��
	- �Ҽ��� 1°�ڸ����� �ݿø��ؼ� ����
				+0.5        *1        (int)        /1
		0.1        0.6                                0
		0.6        1.1                                1

	- �Ҽ��� 2°�ڸ����� �ݿø��ؼ� �Ҽ��� 1¥������ ǥ��
				+0.05        *10        (int)        /10
		0.21        0.26        2.6        2                0.2
		0.26        0.31        3.1        3                0.3
	- �Ҽ��� 3°�ڸ����� �ݿø��ؼ� �Ҽ��� 2¥������ ǥ��
			    +0.005        *100        (int)        /100        
		0.321        0.326        32.6        32                0.32
		0.326        0.331        33.1        33                0.33
*/
import java.io.*;
public class Exam1 { 
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

		// ����
		sum = kor + eng + math;
		avg = ((int)((sum / 3.f + 0.05) * 100)) / 100.f;
		System.out.println("���� : " + sum + ", ��� : " + avg);


	}
}