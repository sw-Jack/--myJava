import java.io.*;
/**
   랜덤값(1-200)을 만들어 사용자 맞추는 프로그램 기회는 10번
*/
public class MyExam13{
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int count = 1; //횟수
      boolean isStop = false;

      int number = (int)(Math.random()*200) + 1;
      System.out.println("***** 1~200사이의 난수를 만들었습니다. *****");
      System.out.println("*************** 맞추어보세요 ***************");

      while(!isStop){
         System.out.println();
         System.out.print("데이터 입력 = ");
         int data = Integer.parseInt(br.readLine());

         if(number > data){
            System.out.println("컴퓨터가 발생한 숫자가 더 큽니다.");
         }else if(number < data){
            System.out.println("컴퓨터가 발생한 숫자가 더 작습니다.");
         }else if(number == data){
            System.out.println("정답입니다. " + count + "번 만에 맞추셨습니다.");
            isStop = true;
            continue;
         }

         if(count == 10){
            System.out.println("실패하였습니다.");
            System.out.print("계속 진행하시겠습니까? (y/n) : ");
            char result = (char)System.in.read();
            System.in.read();System.in.read();//엔터값 처리
            if(result == 'Y' || result == 'y'){
               count = 1;
               System.out.println();
               number = (int)(Math.random()*200) + 1;
               System.out.println("***** 1~200사이의 난수를 만들었습니다. *****");
               System.out.println("*************** 맞추어보세요 ***************");
               System.out.println();
               continue;
            }else{
               System.out.println("프로그램을 종료합니다.");
               isStop = true;
            }
         }
         count++;
      }//end while
   }
}