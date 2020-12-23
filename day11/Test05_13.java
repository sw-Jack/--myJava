import java.io.*;
/**
	가위 바위 보 게임
*/

public class Test05_13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] result = {{0,-1,1}, {1,0,-1}, {-1,1,0}};
		String[] rsp = {"주먹", "가위", "보자기"};
		int money = 1000;
		boolean isStop = false;
		int menu = -1;

		while(!isStop) {
			System.out.println("1.주먹");
			System.out.println("2.가위");
			System.out.println("3.보자기");
			System.out.println("0.게임종료");
			System.out.print("메뉴 선택 : ");
			menu = Integer.parseInt(br.readLine());

			if(menu == 0) { // 종료
				System.out.println();
				System.out.print("정말 종료하시겠습니까? (y/n) : ");
				char reply = (char)System.in.read();
				System.in.read(); System.in.read();
				if(reply == 'Y' || reply == 'y') {
					System.out.println("게임 종료...");
					isStop = true;
					continue;
				} else {
					System.out.println("게임 종료 취소...");
					System.out.println();
					continue;
				}
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
			System.out.print("결과 확인 [Enter]");
			System.in.read(); System.in.read();

			int com = (int)(Math.random() * 3) + 1; // 1 ~ 3 랜덤 : 가위 / 바위 / 보
			System.out.println();
			System.out.println("Computer : " + rsp[com-1] + ", You : " + rsp[menu-1]);
			if(result[com-1][menu-1] == 1) { // 승
				System.out.println("You Win!!");
				money += betting;
			} else if(result[com-1][menu-1] == -1) { // 패
				System.out.println("You Lose!!");
				money -= betting;
			} else if(result[com-1][menu-1] == 0) { // 무
				System.out.println("Draw!!");
			}
			System.out.println("잔액 : " + money);
			System.out.println();

		} // end while
	} // end main
}
	