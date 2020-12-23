import java.io.*;
/**
   로또
*/
public class Test05_18 {
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      System.out.print("몇 게임 하실건가요? : ");
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
         
         int count = 0; // 일치하는 갯수
         for(int tLine=0; tLine<line; tLine++){
            count = 0;
            for(int col=0; col<lotto[line].length; col++){
               for(int tCol=0; tCol<lotto[tLine].length; tCol++){
                  if(lotto[line][col] == lotto[tLine][tCol]){
                     count++; break;
                  }
               }
               if(col == count){//위에서 이미 한칸 이상이 안 같다.
                  break;
               }
            }
            if(count == 6){// 줄 전체가 같더라.
               line--; break;
            }
         }
      }//end for line

      // 정렬... ???

      System.out.println();
      for(int i=0; i<lotto.length; i++){
         System.out.print(i + 1 + "번째 추천번호 : ");
         for(int j=0; j<lotto[i].length; j++){
            System.out.print(lotto[i][j] + "\t");
         }
         System.out.println();
      }
   }
}