import java.io.*;
class CellPhone{
   private String number;
   
   public String getNumber(){
      return number;
   }
   public void setNumber(String number){
      this.number = number;
   }
   public void call(){
      System.out.println("음성통화를 합니다.");
   }
}

class Phone3G extends CellPhone{
   private BufferedReader br;

   public Phone3G(){
      br = new BufferedReader(new InputStreamReader(System.in));
   }

   @Override
   public void call(){
      int menu = -1;

      System.out.println("1.음성통화");
      System.out.println("2.영상통화");
      System.out.print("메뉴선택 : ");
      try{
         menu = Integer.parseInt(br.readLine());
      }catch(NumberFormatException nfe){
         menu = 1;
      }catch(IOException ioe){
         ioe.printStackTrace();
      }

      if(menu != 2){
         super.call();
      } else {
         System.out.println("영상통화를 합니다.");
      }
      
   }
}
public class Test06_24 {
   public static void main(String[] ar)throws IOException{
      CellPhone phone = new Phone3G();
      phone.call();
   }
}