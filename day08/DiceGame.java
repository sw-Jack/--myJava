import java.io.*;

// day07 마지막 연습문제 썜 버전

public class DiceGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = 1000;
		int menu = -1; // 유지보수 오류 루트를 보기 위해 일부러 올 수 없는 값으로 초기화하는 개발자들의 암묵적 패턴
		boolean isStop = false; // ****** 중요 !! -> 이중 while문 안써도됨

		while(!isStop) {
			System.out.println("1.홀수");
			System.out.println("2.짝수");
			System.out.println("0.게임종료");
			System.out.print("메뉴 선택 : ");
			menu = Integer.parseInt(br.readLine());
			
			if(menu == 0) {
				System.out.print("정말로 종료하시겠습니까? (y/n) : ");
				char res = (char)System.in.read();
				System.in.read(); System.in.read();
				if(res == 'y' || res == 'Y') {
					System.out.println("프로그램을 종료합니다...");
					isStop = true;
				} else {
					System.out.println("프로그램 종료를 취소합니다...");
					isStop = false;
				} 
				System.out.println();
				continue;
			}

			if(menu != 1 && menu != 2) {
				System.out.println();
				System.err.println("메뉴 입력 오류! 메뉴를 다시 선택하세요...");
				System.out.println();
				menu = -1;
				continue;
			}

			System.out.println();
			System.out.print("베팅 금액 : ");
			int betting = Integer.parseInt(br.readLine());

			while(betting > money || betting <= 0) {
				System.out.println();
				System.out.println("베팅 금액을 확인하고 다시 입력하세요!");
				System.out.println();
				System.out.print("베팅 금액 : ");
				betting = Integer.parseInt(br.readLine());
			}

			System.out.println();
			System.out.print("주사위 굴리기 : [Enter]");
			System.in.read(); System.in.read();	// Enter값 처리

			System.out.println();
			int dice = (int)(Math.random() * 6) + 1; // 주사위 랜덤 수 생성 : 1 ~ 6 사이 랜덤 값
			System.out.println("주사위 값 : " + dice);
			if((menu+dice)%2 == 0) { // 내가 이기는 경우
				System.out.println("you win!!");
				money += betting;
			} else { // 지는 경우			
				System.out.println("you lose!!");
				money -= betting;
			}
			System.out.println("잔액 : " + money);

			if(money <= 0) {
				System.out.println();
				System.out.println("호갱님. 돈을 모두 잃으셨네요.. 돈 벌어서 다시 오세요^^");
				isStop = true;
			} else if(money >= 5000) {
				System.out.println();
				System.out.println("당신은 타짜군요! 다른데로 꺼지세요!!");
				isStop = true;
			}
			System.out.println();

		} // end for while
	} // end for main
}
