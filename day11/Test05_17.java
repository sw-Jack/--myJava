import java.io.*;
/**
   ������
*/
public class Test05_17 {
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("����(Ȧ����) = ");
      int number = Integer.parseInt(br.readLine());

      int[][] mabang = new int[number][number];

      int row = 0;
      int col = number/2;
      for(int su=1; su<=number*number; su++){
         mabang[row][col] = su;
         if(su % number == 0){
            row++; continue;
         }
         row--;
         col++;
         if(row < 0) row = mabang.length-1;
         if(col > mabang.length-1) col = 0;
      }

      System.out.println();
      for(int i=0; i<mabang.length; i++){
         for(int j=0; j<mabang[i].length; j++){
            System.out.print(mabang[i][j] + "\t");
         }
         System.out.println();
      }
   }
}