import java.io.*;
public class DoWhileEx { // 사용자 메뉴 입력 제한하기
	public static void main(String[] args) throws IOException {

		int menu = 0;
		do {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원조회");
			System.out.println("3. 회원탈퇴");
			System.out.println("0. 프로그램종료");
			System.out.print("메뉴 선택 : ");
			menu = System.in.read() - 48;
			System.in.read(); System.in.read();
			} while(menu != 1 && menu != 2 && menu != 3 && menu != 0);
		System.out.println("선택한 메뉴 : " + menu);
	}
}
