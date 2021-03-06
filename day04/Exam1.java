// 연습 문제 
/*
	# 문제
	국영수 점수를 입력받고 총점과 평균을 구한다.
	평균은 소수점 둘째 자리까지 나타낸다. 단, 평균은 소수 둘째 자리까지 나타낸다.
	소수점을 나타낼 때 printf 를 활용하지 말고 아래의 문제 해결법을 이용해서 나태내라.
	-----------------------------------------------------------------
	# 문제 해결법
	- 소수점 1째자리에서 반올림해서 정수
				+0.5        *1        (int)        /1
		0.1        0.6                                0
		0.6        1.1                                1

	- 소수점 2째자리에서 반올림해서 소수점 1짜리까지 표현
				+0.05        *10        (int)        /10
		0.21        0.26        2.6        2                0.2
		0.26        0.31        3.1        3                0.3
	- 소수점 3째자리에서 반올림해서 소수점 2짜리까지 표현
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
		System.out.print("국어 : ");
		kor = Integer.parseInt(br.readLine());
		System.out.print("영어 : ");
		eng = Integer.parseInt(br.readLine());
		System.out.print("수학 : ");
		math = Integer.parseInt(br.readLine());

		// 총점
		sum = kor + eng + math;
		avg = ((int)((sum / 3.f + 0.05) * 100)) / 100.f;
		System.out.println("총점 : " + sum + ", 평균 : " + avg);


	}
}
