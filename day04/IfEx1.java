import java.io.*;
public class IfEx1 {
	public static void main(String[] args) throws IOException {
		int a;
		String grade = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("점수 입력 : ");
		a = Integer.parseInt(br.readLine());

		if(a >= 90) {
			grade = "A학점";
		} else if(a >= 80) {
			grade = "B학점";
		} else if(a >= 70) {
			grade = "C학점";
		} else if(a >= 60) {
			grade = "D학점";
		} else {
			grade = "F학점";
		}
		System.out.println("당신의 학점 : " + grade);
	}
}
