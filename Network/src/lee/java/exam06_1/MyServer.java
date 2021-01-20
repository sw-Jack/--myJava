package lee.java.exam06_1;
import java.io.*;
import java.net.*;

public class MyServer {
   private Socket socket = null;
   private BufferedReader br = null;
   private BufferedWriter bw = null;
   private BufferedReader keyboard = null;

   public MyServer() {
	   System.out.println("[����]");
      // 1. ���������� ����
      ServerSocket server = null;
      try {
         server = new ServerSocket(5000);
      } catch (IOException e) {
         System.err.println("�ش� ��Ʈ�� ������Դϴ�.");
         System.exit(0);
      }

      try {
         System.out.println("#���� �غ� �Ϸ�");
         socket = server.accept(); // 2. �������� û�� : Ŭ���̾�Ʈ�� ������ ���

         // ���ص� ������ ���� ���ӳ����� �α׷� �����.
         InetAddress client = socket.getInetAddress();
         String clientIp = client.getHostAddress();
         System.out.println("[" + clientIp + "] ���� ������\n");

         // 4. ����� �������κ��� ��Ʈ�� ����
         br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         keyboard = new BufferedReader(new InputStreamReader(System.in)); // Ű����� ���� �Է�

         while (true) {
            // 6. Ŭ���̾�Ʈ �޽����� �޴´�.
            String receive = br.readLine();
            System.out.println("[Ŭ���̾�Ʈ �޼���] " + receive);
            if(receive.equals("exit")) {
                System.out.println("Ŭ���̾�Ʈ���� ������ �����ϰڽ��ϴ�.");
                break;
             }
            
            // 7. Ŭ���̾�Ʈ���� ����޽����� ������.
            System.out.print("������ �޼��� : ");
            String send = keyboard.readLine(); // Ŭ���̾�Ʈ �Է´��
            bw.write(send + "\n"); // 5. Ŭ���̾�Ʈ�� �޽����� ����
            bw.flush();
            if(send.equals("exit")) {
                System.out.println("Ŭ���̾�Ʈ���� ������ �����ϰڽ��ϴ�.");
                break;
            }
         }
         System.out.println("������ �����մϴ�.");
      } catch (IOException e) {
         e.printStackTrace();
      }finally {// 9. ��� �ڿ��� close()
         try { if(bw != null) bw.close(); }catch(IOException ioe) {}
         try { if(br != null) br.close(); }catch(IOException ioe) {}
         try { if(socket != null) socket.close(); }catch(IOException ioe) {}
      }
      
   }

   public static void main(String[] args) {
      new MyServer();
   }
}