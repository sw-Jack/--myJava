import java.io.*;
import java.lang.*;
import java.util.*;
public class GameEx {
	public static void main(String[] args) throws IOException {
		int having_money = 1000;
		String what = "홀수";
		String answer = "홀수";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(having_money > 0 && having_money <= 5000) {
			while(having_money > 0) {
				System.out.print("<목록>\n1.홀수\n2.짝수\n0.게임종료\n메뉴 선택 : ");
				int menu = Integer.parseInt(br.readLine());	// 메뉴 입력 받기
				if(menu == 1) {
					break;
				} else if(menu == 2) {
					what = "짝수"; 
					break;
				} else if(menu == 0) {
					System.out.print("<게임종료>\n정말로 종료하시겠습니까? (y/n) : ");
					String yesno = br.readLine();
					if(yesno.equals("y")) {
						System.out.println("----게임 종료----");
						return;
					} else {
						System.out.println("\n");
						continue;
					}
				} else {
					System.out.println("번호를 다시 선택하세요!\n");
					continue;
				}
			}
	
			// 베팅 금액 설정
			System.out.print("베팅 금액 : ");
			int bet = Integer.parseInt(br.readLine());
			while(bet > having_money || bet <= 0) {
				System.out.println();
				System.out.println("베팅 금액을 확인하고 다시 입력하세요!");
				System.out.println();
				System.out.print("베팅 금액 : ");
				bet = Integer.parseInt(br.readLine());
			}

			System.out.println("\n주사위 던지기 : [Enter]");
			System.in.read(); System.in.read();

			int rand = (int)(Math.random() * 6) + 1;	// 주사위 랜덤값
			if(rand%2 == 0) 
				answer = "짝수";
			
			System.out.println("당신의 예측 : " + what + ", 주사위 : " + rand); // 확인 멘트

			if(answer.equals(what)) {
				having_money += bet;
				System.out.println("You Win!!");
			}
			else {
				having_money -= bet;
				System.out.println("You Lose!!");
			}
			System.out.println("잔액 : " + having_money + "\n");
		}

		if(having_money >= 5000) {
			System.out.println("가진 돈이 5000원 이상이네요! 도박은 소소하게! 게임을 강제 종료합니다!");
			return;
		}
		else if(having_money <= 0) {
			System.out.println("돈을 모두 잃으셨습니다! 돈을 더 가지고 다시 오세요! 게임을 강제 종료합니다!");
			return;
		}
	}
}
