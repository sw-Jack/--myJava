package lee.java.exam04;

public class JoinEx {
	public static void main(String[] args) {
		  System.out.println(Thread.currentThread().getName() + " start");
		  Runnable runnable = new MyRunnable2();
		  Thread th1 = new Thread(runnable);
		  th1.start();
		  
		  try {
			  th1.join(); // th1 �������� ������ ����� ������ ������ ������(main)�� ���
		  } catch(InterruptedException e) {
			  e.printStackTrace();
		  }
		  System.out.println(Thread.currentThread().getName() + " end");
	}
}
