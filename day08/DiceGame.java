import java.io.*;

// day07 ������ �������� �� ����

public class DiceGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = 1000;
		int menu = -1; // �������� ���� ��Ʈ�� ���� ���� �Ϻη� �� �� ���� ������ �ʱ�ȭ�ϴ� �����ڵ��� �Ϲ��� ����
		boolean isStop = false; // ****** �߿� !! -> ���� while�� �Ƚᵵ��

		while(!isStop) {
			System.out.println("1.Ȧ��");
			System.out.println("2.¦��");
			System.out.println("0.��������");
			System.out.print("�޴� ���� : ");
			menu = Integer.parseInt(br.readLine());
			
			if(menu == 0) {
				System.out.print("������ �����Ͻðڽ��ϱ�? (y/n) : ");
				char res = (char)System.in.read();
				System.in.read(); System.in.read();
				if(res == 'y' || res == 'Y') {
					System.out.println("���α׷��� �����մϴ�...");
					isStop = true;
				} else {
					System.out.println("���α׷� ���Ḧ ����մϴ�...");
					isStop = false;
				} 
				System.out.println();
				continue;
			}

			if(menu != 1 && menu != 2) {
				System.out.println();
				System.err.println("�޴� �Է� ����! �޴��� �ٽ� �����ϼ���...");
				System.out.println();
				menu = -1;
				continue;
			}

			System.out.println();
			System.out.print("���� �ݾ� : ");
			int betting = Integer.parseInt(br.readLine());

			while(betting > money || betting <= 0) {
				System.out.println();
				System.out.println("���� �ݾ��� Ȯ���ϰ� �ٽ� �Է��ϼ���!");
				System.out.println();
				System.out.print("���� �ݾ� : ");
				betting = Integer.parseInt(br.readLine());
			}

			System.out.println();
			System.out.print("�ֻ��� ������ : [Enter]");
			System.in.read(); System.in.read();	// Enter�� ó��

			System.out.println();
			int dice = (int)(Math.random() * 6) + 1; // �ֻ��� ���� �� ���� : 1 ~ 6 ���� ���� ��
			System.out.println("�ֻ��� �� : " + dice);
			if((menu+dice)%2 == 0) { // ���� �̱�� ���
				System.out.println("you win!!");
				money += betting;
			} else { // ���� ���			
				System.out.println("you lose!!");
				money -= betting;
			}
			System.out.println("�ܾ� : " + money);

			if(money <= 0) {
				System.out.println();
				System.out.println("ȣ����. ���� ��� �����̳׿�.. �� ��� �ٽ� ������^^");
				isStop = true;
			} else if(money >= 5000) {
				System.out.println();
				System.out.println("����� Ÿ¥����! �ٸ����� ��������!!");
				isStop = true;
			}
			System.out.println();

		} // end for while
	} // end for main
}
