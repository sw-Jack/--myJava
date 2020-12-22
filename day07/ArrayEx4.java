import java.io.*;
/**
	# 성적표 - 여러명에 대한 성적표, 과목명에 대해 자유도를 부여.
	# 실행 : java ArrayEx4 사람수 국어 영어 수학
*/
public class ArrayEx4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 명령어 오기 시 에러 표시
		if(args.length == 0) {
			System.err.println("[Error] : 최소 하나의 정보를 입력하세요.");
			System.err.println("[Usage] : \"java ArrayEx4 사람수 국어 영어 수학\"");
		}

		int human = Integer.parseInt(args[0]);	// 사람 수
		String[] name = new String[human];
		// 과목 수 = subject.length = args.length-1
		String[] subject = new String[args.length-1];
		// 과목 입력 받아 저장
		for(int i=0; i<subject.length; i++)
			subject[i] = args[i+1];

		

		int[][] score = new int[human][subject.length+1];	// subject.length+1 : 총점 공간
		float[] avg = new float[human];	// 평균
		char[] grade = new char[human];	// 학점
		int[] rank = new int[human];	// 등수 


		for(int i=0; i<human; i++) {
			System.out.print(i+1 + "번 학생 이름 : ");
			name[i] = br.readLine();

			System.out.println();
			System.out.println("<" + name[i] + " 학생의 과목별 점수 입력>");
			for(int j=0; j<subject.length; j++) {
				System.out.print(subject[j] + " 점수 입력 : ");
				score[i][j] = Integer.parseInt(br.readLine());	// 과목별 점수 입력 
				score[i][score[i].length-1] += score[i][j];	// 총점 계산
			} // end for j

			avg[i] = score[i][score[i].length-1] / (float)subject.length;
			avg[i] = (int)((avg[i]+ 0.005) * 100) / 100.f;

			switch((int)avg[i]/10) {
				case 10 :
				case 9 : grade[i] = 'A'; break;
				case 8 : grade[i] = 'B'; break;
				case 7 : grade[i] = 'C'; break;
				case 6 : grade[i] = 'D'; break;
				default : grade[i] = 'F'; break;
			}
			System.out.println();
		} // end for a human
		
		// 등수는 모든 사람의 정보 입력 받은 후 산출 **
		for(int i=0; i<human; i++) {
			rank[i]++;
			for(int j=0; j<human; j++) {
				if(avg[i] < avg[j])
					rank[i]++;
			}
		}
			
		System.out.print("\n<성적표>\n이름\t");
		for(int i=0; i<subject.length; i++)
			System.out.print(subject[i] + "\t");
		System.out.println("총점\t평균\t학점\t등수");

		for(int i=0; i<human; i++) {
			System.out.print(name[i] + "\t");
			for(int j=0; j<score[i].length; j++) 
				System.out.print(score[i][j] + "\t");
			System.out.println(avg[i] + "\t" + grade[i] + "\t" + rank[i]);
		}
	}	// end for main
}
