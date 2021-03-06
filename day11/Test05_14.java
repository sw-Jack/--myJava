import java.io.*;
import java.util.*;//날짜.
/**
   주민번호
*/
public class Test05_14 {
   public static void main(String[] ar)throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.print("이름 = ");
      String name = br.readLine();

      int[] jumin = new int[13];
      System.out.print("주민번호 = ");
      for(int i=0; i<jumin.length; i++){
         jumin[i] = System.in.read() - '0';
      }//end for
      System.in.read(); System.in.read();

      //for(int i=0; i<jumin.length; i++) - 확인코드
      //   System.out.println("jumin[" + i + "] = " + jumin[i]);

      float hap = 0; float temp = 0; float total = 0;
      float cre = 2.f;
      for(int i=0; i<jumin.length-1; i++){
         if(cre == 10.f) cre = 2.f;
         hap += jumin[i] * cre;
         cre++;
      }//end for
      temp = 11.f * (int)(hap/11.f) + 11.f - hap;
      total = temp - 10.f * (int)(temp/10.f);
      
      if(total != jumin[jumin.length-1]){
         System.out.println();
         System.out.println("잘못된 주민번호 입니다.");
         return;
      }

      System.out.println();
      System.out.println("[" + name + "] 님의 개인정보 분석결과");
      
      int year = 1900;
      switch(jumin[6]){
         case 3 :
         case 4 : year = 2000; break;
         case 9 :
         case 0 : year = 1800; break;
         default : year = 1900; break;
      }
      year += jumin[0]*10 + jumin[1];
      int month = jumin[2]*10 + jumin[3];
      int day = jumin[4]*10 + jumin[5];
      System.out.println("-> 생년월일 : " + year + "년 " + month + "월 " + day + "일");

      System.out.println("-> 나    이 : " + 
         (Calendar.getInstance().get(Calendar.YEAR) - year) + "세");

      System.out.println("-> 성    별 : " + (jumin[6] % 2 == 0 ? "여성" : "남성"));
	  System.out.print("-> 출생지역 : ");
      switch(jumin[7]){
         case 0 : System.out.println("서울"); break;
         case 1 : System.out.println("경기"); break;
         case 2 : System.out.println("강원"); break;
         case 3 : System.out.println("충북"); break;
         case 4 : System.out.println("충남"); break;
         case 5 : System.out.println("전북"); break;
         case 6 : System.out.println("전남"); break;
         case 7 : System.out.println("경북"); break;
         case 8 : System.out.println("경남"); break;
         case 9 : System.out.println("제주"); break;
      }
   }
}