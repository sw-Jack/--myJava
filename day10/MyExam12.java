import java.io.*;
/**
   ���� �� 2�� ���� ���ذ����� ���� ������ �������.
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
            System.out.println("�����Դϴ�.");
            score += 10;
         }else{
            System.out.println("�����Դϴ�. ������ " + (num1 + num2) + "�Դϴ�.");
         }
         System.out.println();
         if(i == 9){
            System.out.println("����� ������ " + score + "�� �Դϴ�.");
            System.out.println();
            System.out.print("����Ͻðڽ��ϱ�? (y/n) : ");
            char result = (char)System.in.read();
            System.in.read();System.in.read();//���Ͱ� ó��
            if(result == 'Y' || result == 'y'){
               i = -1;
               score = 0;
               System.out.println();
               continue;
            }else{
               System.out.println("���α׷��� �����մϴ�.");
            }
         }
      }//end for
   }
}