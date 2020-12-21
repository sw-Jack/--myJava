import java.io.*;

public class InputEx4 {
	public static void main(String[] args) throws IOException {
		int kor, eng, math, sum;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어 : ");
		// String ex = br.readLine();
		// int kor = Integer.ParseInt(ex);
		kor = Integer.parseInt(br.readLine());

		System.out.print("영어 : ");
		eng = Integer.parseInt(br.readLine());

		System.out.print("수학 : ");
		math = Integer.parseInt(br.readLine());

		sum  = kor + eng + math;

		System.out.println();
		System.out.println("총점 : " + sum);
	}
}
