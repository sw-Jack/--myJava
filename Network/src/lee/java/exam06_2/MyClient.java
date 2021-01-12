package lee.java.exam06_2;
import java.io.*;
import java.net.*;

public class MyClient {
   private Socket socket = null;
   private BufferedReader br = null;
   private BufferedWriter bw = null;
   private BufferedReader keyboard = null;
   
   public MyClient() {
	   System.out.println("[Ŭ���̾�Ʈ]");
      try {
         socket = new Socket("localhost", 5000);// 3. ������ ���ӽõ�
         System.out.println("#���� ���� ����");
      } catch (UnknownHostException ue) {
         System.err.println("�ش� ������ ã�� �� �����ϴ�.");
         System.exit(0);
      } catch (IOException e) {
         System.err.println("#���� ���� ����");
         System.exit(0);
      }
     
      try {
         // 4. ����� �������κ��� ��Ʈ�� ����
         br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
         keyboard = new BufferedReader(new InputStreamReader(System.in)); // Ű����� ���� �Է�
         
         while(true) {
            System.out.print("������ �޼��� : ");
            String message = keyboard.readLine(); // Ŭ���̾�Ʈ �Է´��
            
            bw.write(message + "\n"); // 5. Ŭ���̾�Ʈ�� �޽����� ����
            bw.flush();
            
            //8. ������ ������ �޽����� Ȯ���Ѵ�.
            String recieveMessage = br.readLine();
            System.out.println("[���� �޼���] " + recieveMessage);
            
            if(recieveMessage.equals("exit")) {
               System.out.println("����� �����մϴ�.");
               break;
            }
         }
         System.out.println("�������� ������ ���������ϴ�.");
      } catch (IOException e) {
         e.printStackTrace();
      } finally {// 9. �ڿ��� close()
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