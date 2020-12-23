import java.io.*;
/**
   �ζ�
*/
public class Test05_18 {
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("�� ���� �Ͻǰǰ���? : ");
      int game = Integer.parseInt(br.readLine());

      int[][] lotto = new int[game][6];

      for(int line=0; line<lotto.length; line++){
         for(int col=0; col<lotto[line].length; col++){
            lotto[line][col] = (int)(Math.random() * 45) + 1; // 1 ~ 45
            for(int tCol=0; tCol<col; tCol++){
               if(lotto[line][col] == lotto[line][tCol]){
                  col--; break;
               }
            }
         }//end for col
         
         int count = 0; // ��ġ�ϴ� ����
         for(int tLine=0; tLine<line; tLine++){
            count = 0;
            for(int col=0; col<lotto[line].length; col++){
               for(int tCol=0; tCol<lotto[tLine].length; tCol++){
                  if(lotto[line][col] == lotto[tLine][tCol]){
                     count++; break;
                  }
               }
               if(col == count){//������ �̹� ��ĭ �̻��� �� ����.
                  break;
               }
            }
            if(count == 6){// �� ��ü�� ������.
               line--; break;
            }
         }
      }//end for line

      // ����... ???

      System.out.println();
      for(int i=0; i<lotto.length; i++){
         System.out.print(i + 1 + "��° ��õ��ȣ : ");
         for(int j=0; j<lotto[i].length; j++){
            System.out.print(lotto[i][j] + "\t");
         }
         System.out.println();
      }
   }
}