import java.io.*;
public class ArrayEx2_retry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 2번 망치로 실행 시 오류 문구 출력
		if(args.length == 0) {
			System.err.println("[Error] 최소 1개이 과목명을 입력하시오.");
			System.err.println("[Usage] \"java ArratEx2_retry 국어 영어 수학\"");
			return;
		}


		// 이름 입력 받기 
		System.out.print("이름 : ");
		String name = br.readLine();
		
		// 과목 저장 공간 subject
		String[] subject = new String[args.length];
		for(int i=0; i<subject.length; i++) 
			subject[i] = args[i];


		// 점수 저장 공간 score
		// subject.length+1 처럼 공간하나를 더 만든 이유는 총점을 위한 공간
		int[] score = new int[subject.length+1];
		for(int j=0; j<subject.length; j++) {
			System.out.print(subject[j] + " 점수 : ");
			score[j] = Integer.parseInt(br.readLine());
			score[score.length-1] += score[j]; // 총점 계산
		}



		// 평균 구하기 (소수점 셋째 자리에서 반올림하여 둘째 자리까지 표현)
		float avg = score[score.length-1] / (float)subject.length;
		avg = (int)((avg + 0.005) * 100) / 100.f;


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

		// 입력 및 결과 출력
		
		System.out.print("\n<성적표>\n이름\t");
		for(int k=0; k<subject.length; k++) 
			System.out.print(subject[k] + "\t");
		System.out.print("총점\t평균\t학점\n" + name + "\t");
		for(int p=0; p<score.length; p++) 
			System.out.print(score[p] + "\t");
		System.out.println(avg + "\t" + grade);
	}
}
