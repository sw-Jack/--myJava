import java.io.*;
import java.lang.*;
import java.util.*;
public class GameEx {
	public static void main(String[] args) throws IOException {
		int having_money = 1000;
		String what = "Ȧ��";
		String answer = "Ȧ��";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(having_money > 0 && having_money <= 5000) {
			while(having_money > 0) {
				System.out.print("<���>\n1.Ȧ��\n2.¦��\n0.��������\n�޴� ���� : ");
				int menu = Integer.parseInt(br.readLine());	// �޴� �Է� �ޱ�
				if(menu == 1) {
					break;
				} else if(menu == 2) {
					what = "¦��"; 
					break;
				} else if(menu == 0) {
					System.out.print("<��������>\n������ �����Ͻðڽ��ϱ�? (y/n) : ");
					String yesno = br.readLine();
					if(yesno.equals("y")) {
						System.out.println("----���� ����----");
						return;
					} else {
						System.out.println("\n");
						continue;
					}
				} else {
					System.out.println("��ȣ�� �ٽ� �����ϼ���!\n");
					continue;
				}
			}
	
			// ���� �ݾ� ����
			System.out.print("���� �ݾ� : ");
			int bet = Integer.parseInt(br.readLine());
			while(bet > having_money || bet <= 0) {
				System.out.println();
				System.out.println("���� �ݾ��� Ȯ���ϰ� �ٽ� �Է��ϼ���!");
				System.out.println();
				System.out.print("���� �ݾ� : ");
				bet = Integer.parseInt(br.readLine());
			}

			System.out.println("\n�ֻ��� ������ : [Enter]");
			System.in.read(); System.in.read();

			int rand = (int)(Math.random() * 6) + 1;	// �ֻ��� ������
			if(rand%2 == 0) 
				answer = "¦��";
			
			System.out.println("����� ���� : " + what + ", �ֻ��� : " + rand); // Ȯ�� ��Ʈ

			if(answer.equals(what)) {
				having_money += bet;
				System.out.println("You Win!!");
			}
			else {
				having_money -= bet;
				System.out.println("You Lose!!");
			}
			System.out.println("�ܾ� : " + having_money + "\n");
		}

		if(having_money >= 5000) {
			System.out.println("���� ���� 5000�� �̻��̳׿�! ������ �Ҽ��ϰ�! ������ ���� �����մϴ�!");
			return;
		}
		else if(having_money <= 0) {
			System.out.println("���� ��� �����̽��ϴ�! ���� �� ������ �ٽ� ������! ������ ���� �����մϴ�!");
			return;
		}
	}
}
