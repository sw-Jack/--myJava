import java.io.*;
/**
   ��������
*/
public class Test05_16 {
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("���� ���� = ");
      int number = Integer.parseInt(br.readLine());

      int[] choice = new int[number];
      for(int i=0; i<choice.length; i++){
         System.out.print("����" + (i + 1) + " = ");
         choice[i] = Integer.parseInt(br.readLine());
      }
      
      for(int i=0; i<choice.length-1; i++){
         for(int j=i+1; j<choice.length; j++){
            if(choice[i] > choice[j]){
               int temp = choice[i];
               choice[i] = choice[j];
               choice[j] = temp;
            }
         }
      }
      
      
      System.out.println();
      System.out.print("������ : ");
      for(int i=0; i<choice.length; i++){
         System.out.print(choice[i] + "\t");
      }
      System.out.println();
   }
}