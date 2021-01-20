package lee.java.exam06_2;
import java.io.*;
import java.net.*;

public class MyClient {
   private Socket socket = null;
   private BufferedReader br = null;
   private BufferedWriter bw = null;
   private BufferedReader keyboard = null;
   
   public MyClient() {
	   System.out.println("[클라이언트]");
      try {
         socket = new Socket("localhost", 5000);// 3. 서버에 접속시도
         System.out.println("#서버 접속 성공\n");
      } catch (UnknownHostException ue) {
         System.err.println("해당 서버를 찾을 수 없습니다.");
         System.exit(0);
      } catch (IOException e) {
         System.err.println("#서버 접속 실패");
         System.exit(0);
      }
     
      try {
         // 4. 얻어진 소켓으로부터 스트림 추출
         br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 부터 입력
         
         while(true) {
            System.out.print("전송할 메세지 : ");
            String send = keyboard.readLine(); // 클라이언트 입력대기
            bw.write(send + "\n"); // 5. 클라이언트가 메시지를 전송
            bw.flush();
            if(send.equals("exit")) {
                System.out.println("통신을 종료합니다.");
                break;
            }
            //8. 서버가 보내온 메시지를 확인한다.
            String recieve = br.readLine();
            System.out.println("[서버 메세지] " + recieve);
            if(recieve.equals("exit")) {
               System.out.println("통신을 종료합니다.");
               break;
            }
         }
         System.out.println("서버와의 연결이 끊어졌습니다.");
      } catch (IOException e) {
         e.printStackTrace();
      } finally {// 9. 자원들 close()
         try { if(bw != null) bw.close(); }catch(IOException ioe) {}
         try { if(br != null) br.close(); }catch(IOException ioe) {}
         try { if(keyboard != null) keyboard.close(); }catch(IOException ioe) {}
         try { if(socket != null) socket.close(); }catch(IOException ioe) {}
      }
   }
   
   public static void main(String[] args) {
      new MyClient();
   }
}