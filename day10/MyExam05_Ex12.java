import java.io.*;
/**
   3�ڸ� �߱�����. 10�� ��ȸ
*/
public class MyExam05_Ex12{
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("������ �����Ͻðڽ��ϱ�? (y/n) : ");
      char result = (char)System.in.read();
      System.in.read();System.in.read();//���Ͱ� ó��
      if(result != 'Y' && result != 'y'){
         System.out.println("������ ����մϴ�.");
         return;
      }

      System.out.println("���ڸ� �����߽��ϴ�.");
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
         System.out.print("����� �����ϴ� ���� = " );
         su[0] = System.in.read() - 48;
         su[1] = System.in.read() - 48;
         su[2] = System.in.read() - 48;
         System.in.read();System.in.read();//���Ͱ� ó��

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
            System.out.println("�����Դϴ�.");
            break;
         }

         System.out.println(i + 1 + "�� " + strike + "��Ʈ����ũ " + ball + "��");

         if(i==9){
            System.out.println("�����߽��ϴ�.");
            System.out.print("��ǻ�� ������ ���� = ");
            for(int j=0; j<number.length; j++){
               System.out.print(number[j]);
            }
            System.out.println();
         }
      }//end for i 10

   }
}