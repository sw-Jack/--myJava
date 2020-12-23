import java.io.*;
/**
   버블정렬
*/
public class Test05_15 {
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("숫자 개수 = ");
      int number = Integer.parseInt(br.readLine());

      int[] bubble = new int[number];
      for(int i=0; i<bubble.length; i++){
         System.out.print("숫자" + (i + 1) + " = ");
         bubble[i] = Integer.parseInt(br.readLine());
      }
      

      for(int i=0; i<bubble.length-1; i++){
         for(int j=0; j<bubble.length-i-1; j++){
            if(bubble[j] > bubble[j+1]){
               int temp = bubble[j];
               bubble[j] = bubble[j+1];
               bubble[j+1] = temp;
            }
         }
      }//end for
      
      System.out.println();
      System.out.print("결과출력 : ");
      for(int i=0; i<bubble.length; i++){
         System.out.print(bubble[i] + "\t");
      }
      System.out.println();
   }
}