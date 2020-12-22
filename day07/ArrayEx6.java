import java.io.*;
/**
	# 성적표 - 여러 명에 대한 성적표, 과목수와 과목명에 대해서 자유도를 부여.
	# 실행 : java ArrayEx6 사람수 
*/
public class ArrayEx6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 인자 미입력시 경고문 출력
		if(args.length == 0 ) {
			System.err.println("[Error] : 최소 하나의 인자를 입력하세요.");
			System.err.println("[Usage] : \"java ArrayEx6 사람수\"");
		}

		int human = Integer.parseInt(args[0]);	// 사람수
		String[] name = new String[human];
		String[][] subject = new String[human][];	// 가변길이 
		int[][] score = new int[human][];	// 가변길이
		float[] avg = new float[human];
		char[] grade = new char[human];
		int[] rank = new int[human];

		for(int i=0; i<human; i++) {
			System.out.print(i+1 + "번 학생 이름 : ");
			name[i] = br.readLine();

			System.out.println();
			System.out.print(name[i] + " 학생의 응시 과목수 : ");
			int number = Integer.parseInt(br.readLine());

			subject[i] = new String[number];	// 과목수 = number = subject[i].length
			for(int j=0; j<subject[i].length; j++) {
				System.out.print(j+1 + "번째 응시 과목명 : ");
				subject[i][j] = br.readLine();
			}
			System.out.println();
			System.out.println(name[i] + " 학생의 과목별 점수 입력");
			score[i] = new int[subject[i].length+1];	// +1 은 총점을 위한 공간
			for(int k=0; k<subject[i].length; k++) {
				System.out.print(subject[i][k] + " 점수 : ");
				score[i][k] = Integer.parseInt(br.readLine());	// 점수 입력
				score[i][score[i].length-1] += score[i][k];	// 총점 계산
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
	
		// 등수 구하기 
		for(int i=0; i<human; i++) {
			rank[i]++;
			for(int j=0; j<human; j++) {
				if(avg[i] < avg[j])
					rank[i]++;
			}
		} // end for rank

		// 결과 출력
		System.out.println();
		for(int i=0; i<human; i++) {
			for(int p=0; p<subject[i].length; p++) 
				System.out.print("**********");
			System.out.print("성적표");
			for(int q=0; q<subject[i].length; q++) 
				System.out.print("**********");
		
			System.out.print("\n이름\t");
			for(int j=0; j<subject[i].length; j++) 
				System.out.print(subject[i][j] + "\t");
			System.out.println("총점\t평균\t학점\t등수");

			System.out.print(name[i] + "\t");
			for(int k=0; k<score[i].length; k++) 
				System.out.print(score[i][k] + "\t");
			System.out.println(avg[i] + "\t" + grade[i] + "\t" + rank[i]);
		}
	}	// end for main
}	

