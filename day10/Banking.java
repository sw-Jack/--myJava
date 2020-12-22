import java.io.*;
public class Banking {
	public static void main(String[] args) throws IOException {
		Account account = new Account("ȫ�浿");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strWork;

		do {
			System.out.println("\n<KG ��ŷ �ý���>\n===========================");
			System.out.println("1.��    ��\n2.��    ��\n3.�ܰ�Ȯ��\n0.��    ��\n===========================");

			System.out.print("�۾� ���� ���� : ");
			strWork = br.readLine();

			int intWork = 0;
			if(!strWork.equals("")) 
				intWork = Integer.parseInt(strWork);
			else {
				System.out.println("�۾� ������ �Է��ϼ���...");
				continue;
			}

			switch(intWork) {
				case 0 : // ����
					System.out.println("[�ý��� ����]...");
					break;
				case 1 : // �Ա�
					System.out.println("\n===========================");
					System.out.print("�Ա��� �ݾ� : ");
					String strDeposit = br.readLine();
					long longDeposit = Long.parseLong(strDeposit);
					account.deposit(longDeposit);
					break;
				case 2 : // ���
					System.out.println("\n===========================");
					System.out.print("����� �ݾ� : ");
					String strWithdraw = br.readLine();
					long longWithdraw = Long.parseLong(strWithdraw);
					account.withdraw(longWithdraw);
					break;
				case 3:
					System.out.println("\n===========================");
					System.out.println(account.getName() + "���� �ܰ� : " + 
						account.getBalance() + "��");
					break;
				default : 
					System.out.print("0 ~ 3 ���� ���� �Է�\n");
			} 
		} while(!strWork.equals("0"));
	}
}