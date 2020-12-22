import java.io.*;
public class Banking {
	public static void main(String[] args) throws IOException {
		Account account = new Account("홍길동");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strWork;

		do {
			System.out.println("\n<KG 뱅킹 시스템>\n===========================");
			System.out.println("1.입    금\n2.출    금\n3.잔고확인\n0.종    료\n===========================");

			System.out.print("작업 내용 선택 : ");
			strWork = br.readLine();

			int intWork = 0;
			if(!strWork.equals("")) 
				intWork = Integer.parseInt(strWork);
			else {
				System.out.println("작업 내용을 입력하세요...");
				continue;
			}

			switch(intWork) {
				case 0 : // 종료
					System.out.println("[시스템 종료]...");
					break;
				case 1 : // 입금
					System.out.println("\n===========================");
					System.out.print("입금할 금액 : ");
					String strDeposit = br.readLine();
					long longDeposit = Long.parseLong(strDeposit);
					account.deposit(longDeposit);
					break;
				case 2 : // 출금
					System.out.println("\n===========================");
					System.out.print("출금할 금액 : ");
					String strWithdraw = br.readLine();
					long longWithdraw = Long.parseLong(strWithdraw);
					account.withdraw(longWithdraw);
					break;
				case 3:
					System.out.println("\n===========================");
					System.out.println(account.getName() + "님의 잔고 : " + 
						account.getBalance() + "원");
					break;
				default : 
					System.out.print("0 ~ 3 사이 숫자 입력\n");
			} 
		} while(!strWork.equals("0"));
	}
}