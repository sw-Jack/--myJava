import java.io.*;
/**
   ������(1-200)�� ����� ����� ���ߴ� ���α׷� ��ȸ�� 10��
*/
public class MyExam13{
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int count = 1; //Ƚ��
      boolean isStop = false;

      int number = (int)(Math.random()*200) + 1;
      System.out.println("***** 1~200������ ������ ��������ϴ�. *****");
      System.out.println("*************** ���߾���� ***************");

      while(!isStop){
         System.out.println();
         System.out.print("������ �Է� = ");
         int data = Integer.parseInt(br.readLine());

         if(number > data){
            System.out.println("��ǻ�Ͱ� �߻��� ���ڰ� �� Ů�ϴ�.");
         }else if(number < data){
            System.out.println("��ǻ�Ͱ� �߻��� ���ڰ� �� �۽��ϴ�.");
         }else if(number == data){
            System.out.println("�����Դϴ�. " + count + "�� ���� ���߼̽��ϴ�.");
            isStop = true;
            continue;
         }

         if(count == 10){
            System.out.println("�����Ͽ����ϴ�.");
            System.out.print("��� �����Ͻðڽ��ϱ�? (y/n) : ");
            char result = (char)System.in.read();
            System.in.read();System.in.read();//���Ͱ� ó��
            if(result == 'Y' || result == 'y'){
               count = 1;
               System.out.println();
               number = (int)(Math.random()*200) + 1;
               System.out.println("***** 1~200������ ������ ��������ϴ�. *****");
               System.out.println("*************** ���߾���� ***************");
               System.out.println();
               continue;
            }else{
               System.out.println("���α׷��� �����մϴ�.");
               isStop = true;
            }
         }
         count++;
      }//end while
   }
}