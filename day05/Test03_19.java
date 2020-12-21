import java.io.*;

// 소문자 / 대문자 변환 문제
public class Test03_19 { 
	public static void main(String[] args) throws IOException {
		System.out.print("알파벳 입력 : ");
		char alpha = (char) System.in.read(); // 1byte -> 2byte

		// 대문자 : 65 ~ 90, 소문자 : 97 ~ 122 => 차이 : 32
		if(alpha >= 65 &&  alpha <= 90) { // 대문자 -> 소문자
			alpha += 32;
		} else { // 소문자 -> 대문자
			alpha -= 32;
		}

		System.out.println("변환 후 문자 : " + alpha);
	}
}
