import java.io.*;
/**
   3자리 야구게임. 10번 기회
*/
public class MyExam05_Ex12{
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("게임을 진행하시겠습니까? (y/n) : ");
      char result = (char)System.in.read();
      System.in.read();System.in.read();//엔터값 처리
      if(result != 'Y' && result != 'y'){
         System.out.println("게임을 취소합니다.");
         return;
      }

      System.out.println("숫자를 생성했습니다.");
      int[] number = new int[3];
      for(int i=0; i<number.length; i++){
         number[i] = (int)(Math.random()*10); // 0~9
         for(int j=0; j<i; j++){
            if(number[i] == number[j]){
               i--;
               break;
            }
         }
      }

      System.out.println();
      int[] su = new int[3];
      for(int i=0; i<10; i++){
         System.out.print("당신이 생각하는 숫자 = " );
         su[0] = System.in.read() - 48;
         su[1] = System.in.read() - 48;
         su[2] = System.in.read() - 48;
         System.in.read();System.in.read();//엔터값 처리

         int strike = 0;
         int ball = 0;

         for(int j=0; j<number.length; j++){
            for(int k=0; k<su.length; k++){
               if(number[j] == su[k]){
                  if(j == k){
                     strike++; break;
                  }else{
                     ball++; break;
                  }
               }
            }
         }//end for j
         
         if(strike == 3){
            System.out.println("정답입니다.");
            break;
         }

         System.out.println(i + 1 + "구 " + strike + "스트라이크 " + ball + "볼");

         if(i==9){
            System.out.println("실패했습니다.");
            System.out.print("컴퓨터 생성한 숫자 = ");
            for(int j=0; j<number.length; j++){
               System.out.print(number[j]);
            }
            System.out.println();
         }
      }//end for i 10

   }
}