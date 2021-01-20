package lee.java.exam06_1;
import java.io.*;
import java.net.*;

public class MyServer {
   private Socket socket = null;
   private BufferedReader br = null;
   private BufferedWriter bw = null;
   private BufferedReader keyboard = null;

   public MyServer() {
	   System.out.println("[서버]");
      // 1. 서버소켓을 생성
      ServerSocket server = null;
      try {
         server = new ServerSocket(5000);
      } catch (IOException e) {
         System.err.println("해당 포트가 사용중입니다.");
         System.exit(0);
      }

      try {
         System.out.println("#서버 준비 완료");
         socket = server.accept(); // 2. 서버에서 청취 : 클라이언트의 접속을 대기

         // 안해도 되지만 보통 접속내용을 로그로 남긴다.
         InetAddress client = socket.getInetAddress();
         String clientIp = client.getHostAddress();
         System.out.println("[" + clientIp + "] 님이 접속함\n");

         // 4. 얻어진 소켓으로부터 스트림 추출
         br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 부터 입력

         while (true) {
            // 6. 클라이언트 메시지를 받는다.
            String receive = br.readLine();
            System.out.println("[클라이언트 메세지] " + receive);
            if(receive.equals("exit")) {
                System.out.println("클라이언트와의 연결을 종료하겠습니다.");
                break;
             }
            
            // 7. 클라이언트에게 응답메시지를 보낸다.
            System.out.print("전송할 메세지 : ");
            String send = keyboard.readLine(); // 클라이언트 입력대기
            bw.write(send + "\n"); // 5. 클라이언트가 메시지를 전송
            bw.flush();
            if(send.equals("exit")) {
                System.out.println("클라이언트와의 연결을 종료하겠습니다.");
                break;
            }
         }
         System.out.println("서버를 종료합니다.");
      } catch (IOException e) {
         e.printStackTrace();
      }finally {// 9. 모든 자원을 close()
         try { if(bw != null) bw.close(); }catch(IOException ioe) {}
         try { if(br != null) br.close(); }catch(IOException ioe) {}
         try { if(socket != null) socket.close(); }catch(IOException ioe) {}
      }
      
   }

   public static void main(String[] args) {
      new MyServer();
   }
}