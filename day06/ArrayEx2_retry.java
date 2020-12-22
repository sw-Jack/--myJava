import java.io.*;
public class ArrayEx2_retry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2�� ��ġ�� ���� �� ���� ���� ���
		if(args.length == 0) {
			System.err.println("[Error] �ּ� 1���� ������� �Է��Ͻÿ�.");
			System.err.println("[Usage] \"java ArratEx2_retry ���� ���� ����\"");
			return;
		}


		// �̸� �Է� �ޱ� 
		System.out.print("�̸� : ");
		String name = br.readLine();
		
		// ���� ���� ���� subject
		String[] subject = new String[args.length];
		for(int i=0; i<subject.length; i++) 
			subject[i] = args[i];


		// ���� ���� ���� score
		// subject.length+1 ó�� �����ϳ��� �� ���� ������ ������ ���� ����
		int[] score = new int[subject.length+1];
		for(int j=0; j<subject.length; j++) {
			System.out.print(subject[j] + " ���� : ");
			score[j] = Integer.parseInt(br.readLine());
			score[score.length-1] += score[j]; // ���� ���
		}



		// ��� ���ϱ� (�Ҽ��� ��° �ڸ����� �ݿø��Ͽ� ��° �ڸ����� ǥ��)
		float avg = score[score.length-1] / (float)subject.length;
		avg = (int)((avg + 0.005) * 100) / 100.f;


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

		// �Է� �� ��� ���
		
		System.out.print("\n<����ǥ>\n�̸�\t");
		for(int k=0; k<subject.length; k++) 
			System.out.print(subject[k] + "\t");
		System.out.print("����\t���\t����\n" + name + "\t");
		for(int p=0; p<score.length; p++) 
			System.out.print(score[p] + "\t");
		System.out.println(avg + "\t" + grade);
	}
}
