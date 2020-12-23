import java.io.*;
/**
	���� ���� �� ����
*/

public class Test05_13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] result = {{0,-1,1}, {1,0,-1}, {-1,1,0}};
		String[] rsp = {"�ָ�", "����", "���ڱ�"};
		int money = 1000;
		boolean isStop = false;
		int menu = -1;

		while(!isStop) {
			System.out.println("1.�ָ�");
			System.out.println("2.����");
			System.out.println("3.���ڱ�");
			System.out.println("0.��������");
			System.out.print("�޴� ���� : ");
			menu = Integer.parseInt(br.readLine());

			if(menu == 0) { // ����
				System.out.println();
				System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) : ");
				char reply = (char)System.in.read();
				System.in.read(); System.in.read();
				if(reply == 'Y' || reply == 'y') {
					System.out.println("���� ����...");
					isStop = true;
					continue;
				} else {
					System.out.println("���� ���� ���...");
					System.out.println();
					continue;
				}
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
			System.out.print("��� Ȯ�� [Enter]");
			System.in.read(); System.in.read();

			int com = (int)(Math.random() * 3) + 1; // 1 ~ 3 ���� : ���� / ���� / ��
			System.out.println();
			System.out.println("Computer : " + rsp[com-1] + ", You : " + rsp[menu-1]);
			if(result[com-1][menu-1] == 1) { // ��
				System.out.println("You Win!!");
				money += betting;
			} else if(result[com-1][menu-1] == -1) { // ��
				System.out.println("You Lose!!");
				money -= betting;
			} else if(result[com-1][menu-1] == 0) { // ��
				System.out.println("Draw!!");
			}
			System.out.println("�ܾ� : " + money);
			System.out.println();

		} // end while
	} // end main
}
	