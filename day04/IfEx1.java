import java.io.*;
public class IfEx1 {
	public static void main(String[] args) throws IOException {
		int a;
		String grade = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���� �Է� : ");
		a = Integer.parseInt(br.readLine());

		if(a >= 90) {
			grade = "A����";
		} else if(a >= 80) {
			grade = "B����";
		} else if(a >= 70) {
			grade = "C����";
		} else if(a >= 60) {
			grade = "D����";
		} else {
			grade = "F����";
		}
		System.out.println("����� ���� : " + grade);
	}
}