import java.io.*;

/**
	# 성적표 만들기 - 한 사람에 대한 성적표 / 과목명에 대해 자유도를 부여
	# 실행 : java ArrayEx2 국어 영어 수학
*/
public class ArrayEx2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2번 망치로 실행 시 오류 문구 출력
		if(args.length == 0) {
			System.err.println("[Error] : 과목명을 최소한 한 과목 이상 입력해야 합니다!!");
			System.err.println("[Usage] : \"java ArrayEx2 과목명1 과목명2 ... 과목명n\"");
			return; // System.exit(0);
		}
		System.out.print("이름 : ");
		String name = br.readLine();
		
		// 과목 저장 공간 subject
		String[] subject = new String[args.length]; 
													  
		for(int i=0; i<subject.length; i++)
			subject[i] = args[i];	// 과목명 불러오기 

		// 점수 저장 공간 score
		// subject.length+1 처럼 공간하나를 더 만든 이유는 총점을 위한 공간
		int[] score = new int[subject.length+1]; 
		for(int j=0; j<subject.length; j++) {
			System.out.print(subject[j] + "점수 : ");
			score[j] = Integer.parseInt(br.readLine());	// 점수 입력
			score[score.length-1] += score[j];	// 마지막 인덱스인 총점 계산 *****
		}

		// 평균 구하기
		float avg = score[score.length-1] / (float)subject.length;
		avg = (int)((avg + 0.005) * 100) / 100.f; // 소수점 셋째 자리에서 반올림하여 둘째 자리까지 표현

		// 학점 구하기
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
		System.out.print("이름\t");
		for(int k=0; k<subject.length; k++) 
			System.out.print(subject[k] + "\t");
		System.out.println("총점\t평균\t학점");
		System.out.print(name + "\t");
		for(int p=0; p<score.length; p++)
			System.out.print(score[p] + "\t");
		System.out.println(avg + "\t" + grade);
	}
}
 