import java.io.*;
/**
   랜덤 값 2개 만들어서 더해가지고 답을 맞으면 점수계산.
*/
public class MyExam12{
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int score = 0;

      for(int i=0; i<10; i++){
         int num1 = (int)(Math.random()*100) + 1;
         int num2 = (int)(Math.random()*100) + 1;
         System.out.print("[" + (i+1) + "] " + num1 + " + " + num2 + " = " );
         int dap = Integer.parseInt(br.readLine());

         if(dap == (num1 + num2)){
            System.out.println("정답입니다.");
            score += 10;
         }else{
            System.out.println("오답입니다. 정답은 " + (num1 + num2) + "입니다.");
         }
         System.out.println();
         if(i == 9){
            System.out.println("당신의 점수는 " + score + "점 입니다.");
            System.out.println();
            System.out.print("계속하시겠습니까? (y/n) : ");
            char result = (char)System.in.read();
            System.in.read();System.in.read();//엔터값 처리
            if(result == 'Y' || result == 'y'){
               i = -1;
               score = 0;
               System.out.println();
               continue;
            }else{
               System.out.println("프로그램을 종료합니다.");
            }
         }
      }//end for
   }
}