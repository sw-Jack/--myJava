import java.io.*;
public class Banking{//Banking.java
    public static void main(String[] args) throws IOException{
      NewAccount na = new NewAccount("홍길동", "1111");
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String strWork;
      int cnt = 0;
	  do {
		  System.out.print("비밀번호 입력 : ");
		  strWork = br.readLine();
		  if(!na.passCheck(strWork)) {
			  cnt++;
			  System.err.println("비밀번호 오류");   
			  System.out.println();
		  }
		  if(cnt >= 3) {
			  System.out.println("비밀번호 입력 3회 오류!\n시스템을 종료합니다...");
			  System.exit(0);
		  }
      } while(!na.passCheck(strWork));

      do{
         System.out.println("\n \n 작업내용을 선택하세요");
         System.out.println("=========================");
         System.out.println("입        금 =======>      1");
         System.out.println("출        금 =======>      2");
         System.out.println("잔 고  확 인 =======>      3");
         System.out.println("비밀번호변경 =======>      4");
         System.out.println("종        료 =======>      0");
         System.out.println("=========================");
         System.out.print("작업내용을 선택하세요 : ");
         strWork = br.readLine();
         int switchInt = 0;
         if(!strWork.equals(""))  
            switchInt = Integer.parseInt(strWork);
         else{
            System.out.println("작업내용을 입력하지 않았습니다.");
            continue;
		 }
         switch(switchInt){
         case 0:   break;
         case 1:
            System.out.println("\n =================");
            System.out.print("금액을 입력하세요 : ");
            String strdepositIn = br.readLine();
            long depositLong = Long.parseLong(strdepositIn);
            na.deposit(depositLong);
            break;
         case 2:
           System.out.println("\n =================");
           System.out.print("금액을 입력하세요 : ");
           String strwithdrawIn = br.readLine();
           long withdrawLong = Long.parseLong(strwithdrawIn);
           na.withdraw(withdrawLong);
           break;
         case 3:
            System.out.println(na.getName() + "님의 잔고는 " +    na.getBalance() + 
               " 원이고 비밀번호는 " + na.getPass() + "입니다.");
            break;
         case 4:
           System.out.println("\n =================");
           System.out.print("변경할 비밀번호를 입력하세요 : ");
           String strPass = br.readLine();
           na.setPass(strPass);
           System.out.println("성공적으로 비밀번호를 변경하였습니다.");
           break;
         default:
            System.out.println("0 ~ 4 사이 숫자 입력\n");
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

   문자열 비교시 equals()메서드 사용
   a.equals(b); true
   c.equals(d); true

*/