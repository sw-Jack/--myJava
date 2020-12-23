import java.io.*;
public class Banking{//Banking.java
    public static void main(String[] args) throws IOException{
      NewAccount na = new NewAccount("ȫ�浿", "1111");
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String strWork;
      int cnt = 0;
	  do {
		  System.out.print("��й�ȣ �Է� : ");
		  strWork = br.readLine();
		  if(!na.passCheck(strWork)) {
			  cnt++;
			  System.err.println("��й�ȣ ����");   
			  System.out.println();
		  }
		  if(cnt >= 3) {
			  System.out.println("��й�ȣ �Է� 3ȸ ����!\n�ý����� �����մϴ�...");
			  System.exit(0);
		  }
      } while(!na.passCheck(strWork));

      do{
         System.out.println("\n \n �۾������� �����ϼ���");
         System.out.println("=========================");
         System.out.println("��        �� =======>      1");
         System.out.println("��        �� =======>      2");
         System.out.println("�� ��  Ȯ �� =======>      3");
         System.out.println("��й�ȣ���� =======>      4");
         System.out.println("��        �� =======>      0");
         System.out.println("=========================");
         System.out.print("�۾������� �����ϼ��� : ");
         strWork = br.readLine();
         int switchInt = 0;
         if(!strWork.equals(""))  
            switchInt = Integer.parseInt(strWork);
         else{
            System.out.println("�۾������� �Է����� �ʾҽ��ϴ�.");
            continue;
		 }
         switch(switchInt){
         case 0:   break;
         case 1:
            System.out.println("\n =================");
            System.out.print("�ݾ��� �Է��ϼ��� : ");
            String strdepositIn = br.readLine();
            long depositLong = Long.parseLong(strdepositIn);
            na.deposit(depositLong);
            break;
         case 2:
           System.out.println("\n =================");
           System.out.print("�ݾ��� �Է��ϼ��� : ");
           String strwithdrawIn = br.readLine();
           long withdrawLong = Long.parseLong(strwithdrawIn);
           na.withdraw(withdrawLong);
           break;
         case 3:
            System.out.println(na.getName() + "���� �ܰ�� " +    na.getBalance() + 
               " ���̰� ��й�ȣ�� " + na.getPass() + "�Դϴ�.");
            break;
         case 4:
           System.out.println("\n =================");
           System.out.print("������ ��й�ȣ�� �Է��ϼ��� : ");
           String strPass = br.readLine();
           na.setPass(strPass);
           System.out.println("���������� ��й�ȣ�� �����Ͽ����ϴ�.");
           break;
         default:
            System.out.println("0 ~ 4 ���� ���� �Է�\n");
         }
      }while(!strWork.equals("0"));
    }
}
/*
   String a = "test";
   String b = "test";

   String c = new String("test");
   String d = new String("test");

   a == b : true
   c == d : false

   ���ڿ� �񱳽� equals()�޼��� ���
   a.equals(b); true
   c.equals(d); true

*/