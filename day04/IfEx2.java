// 암호화 & 복호화 예제
import java.io.*;
public class IfEx2 {
	public static void main(String[] args) throws IOException {

	char a = 0;
	char b = 0;
	char c = 0;
	int d = 0;
	
	System.out.print("암호문 : ");
	a = (char)System.in.read();
	b = (char)System.in.read();
	c = (char)System.in.read();
	System.in.read(); System.in.read(); // Enter값 처리

	System.out.print("키워드 입력 (1 ~ 3) : ");
	d = System.in.read() - '0';
	System.in.read(); System.in.read();

	/*
	if(d == 1) {
		a += 1; b += 1; c += 1;
	} else if(d == 2) {
		a += 2; b += 2; c += 2;

	} else { 
		System.out.println("키워드 오류");
		System.exit(0); // 프로그램 종료
	}
	*/
	if(d != 1 && d != 2)  {
		System.out.println("키워드 오류");
		System.exit(0);
	} else {
		a+=d; b+=d; c+=d;
	}

	System.out.println("변경된 암호문 : " + a + b + c);
	System.out.println(); // 송신자

	System.out.print("복호화 키워드 : "); // 수신자
	d = System.in.read() - 48;
	if(d != 1 && d != 2 && d != 3)  {
		System.out.println("복호화 범위 초과");
		System.exit(0);
	}
	a-=d; b-=d; c-=d;
	System.out.println("전송된 암호문 : " + a + b + c);
	}

}
