import java.io.*;
/**
	# ����ǥ - ���� �� ���� ����ǥ, ������� ����� ���ؼ� �������� �ο�.
	# ���� : java ArrayEx6 ����� 
*/
public class ArrayEx6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� ���Է½� ��� ���
		if(args.length == 0 ) {
			System.err.println("[Error] : �ּ� �ϳ��� ���ڸ� �Է��ϼ���.");
			System.err.println("[Usage] : \"java ArrayEx6 �����\"");
		}

		int human = Integer.parseInt(args[0]);	// �����
		String[] name = new String[human];
		String[][] subject = new String[human][];	// �������� 
		int[][] score = new int[human][];	// ��������
		float[] avg = new float[human];
		char[] grade = new char[human];
		int[] rank = new int[human];

		for(int i=0; i<human; i++) {
			System.out.print(i+1 + "�� �л� �̸� : ");
			name[i] = br.readLine();

			System.out.println();
			System.out.print(name[i] + " �л��� ���� ����� : ");
			int number = Integer.parseInt(br.readLine());

			subject[i] = new String[number];	// ����� = number = subject[i].length
			for(int j=0; j<subject[i].length; j++) {
				System.out.print(j+1 + "��° ���� ����� : ");
				subject[i][j] = br.readLine();
			}
			System.out.println();
			System.out.println(name[i] + " �л��� ���� ���� �Է�");
			score[i] = new int[subject[i].length+1];	// +1 �� ������ ���� ����
			for(int k=0; k<subject[i].length; k++) {
				System.out.print(subject[i][k] + " ���� : ");
				score[i][k] = Integer.parseInt(br.readLine());	// ���� �Է�
				score[i][score[i].length-1] += score[i][k];	// ���� ���
			}

			avg[i] = score[i][score[i].length-1] / (float)subject[i].length;
			avg[i] = (int)((avg[i] + 0.005) * 100) / 100.f;

			switch((int)avg[i]/10) {
				case 10 :
				case 9 : grade[i] = 'A'; break;
				case 8 : grade[i] = 'B'; break;
				case 7 : grade[i] = 'C'; break;
				case 6 : grade[i] = 'D'; break;
				default : grade[i] = 'F'; break;
			}
			System.out.println();
		}	// end for a human
	
		// ��� ���ϱ� 
		for(int i=0; i<human; i++) {
			rank[i]++;
			for(int j=0; j<human; j++) {
				if(avg[i] < avg[j])
					rank[i]++;
			}
		} // end for rank

		// ��� ���
		System.out.println();
		for(int i=0; i<human; i++) {
			for(int p=0; p<subject[i].length; p++) 
				System.out.print("**********");
			System.out.print("����ǥ");
			for(int q=0; q<subject[i].length; q++) 
				System.out.print("**********");
		
			System.out.print("\n�̸�\t");
			for(int j=0; j<subject[i].length; j++) 
				System.out.print(subject[i][j] + "\t");
			System.out.println("����\t���\t����\t���");

			System.out.print(name[i] + "\t");
			for(int k=0; k<score[i].length; k++) 
				System.out.print(score[i][k] + "\t");
			System.out.println(avg[i] + "\t" + grade[i] + "\t" + rank[i]);
		}
	}	// end for main
}	

