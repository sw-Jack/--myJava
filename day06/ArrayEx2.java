import java.io.*;

/**
	# ����ǥ ����� - �� ����� ���� ����ǥ / ����� ���� �������� �ο�
	# ���� : java ArrayEx2 ���� ���� ����
*/
public class ArrayEx2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2�� ��ġ�� ���� �� ���� ���� ���
		if(args.length == 0) {
			System.err.println("[Error] : ������� �ּ��� �� ���� �̻� �Է��ؾ� �մϴ�!!");
			System.err.println("[Usage] : \"java ArrayEx2 �����1 �����2 ... �����n\"");
			return; // System.exit(0);
		}
		System.out.print("�̸� : ");
		String name = br.readLine();
		
		// ���� ���� ���� subject
		String[] subject = new String[args.length]; 
													  
		for(int i=0; i<subject.length; i++)
			subject[i] = args[i];	// ����� �ҷ����� 

		// ���� ���� ���� score
		// subject.length+1 ó�� �����ϳ��� �� ���� ������ ������ ���� ����
		int[] score = new int[subject.length+1]; 
		for(int j=0; j<subject.length; j++) {
			System.out.print(subject[j] + "���� : ");
			score[j] = Integer.parseInt(br.readLine());	// ���� �Է�
			score[score.length-1] += score[j];	// ������ �ε����� ���� ��� *****
		}

		// ��� ���ϱ�
		float avg = score[score.length-1] / (float)subject.length;
		avg = (int)((avg + 0.005) * 100) / 100.f; // �Ҽ��� ��° �ڸ����� �ݿø��Ͽ� ��° �ڸ����� ǥ��

		// ���� ���ϱ�
		char grade = 0;
		switch((int)avg/10) {
			case 10 : 
			case 9 : grade = 'A'; break;
			case 8 : grade = 'B'; break;
			case 7 : grade = 'C'; break;
			case 6 : grade = 'D'; break;
			default : grade = 'F'; break;
		}

		System.out.println();
		System.out.print("�̸�\t");
		for(int k=0; k<subject.length; k++) 
			System.out.print(subject[k] + "\t");
		System.out.println("����\t���\t����");
		System.out.print(name + "\t");
		for(int p=0; p<score.length; p++)
			System.out.print(score[p] + "\t");
		System.out.println(avg + "\t" + grade);
	}
}
 