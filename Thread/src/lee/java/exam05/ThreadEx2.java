package lee.java.exam05;

public class ThreadEx2 {

	public static void main(String[] args) {
		ThreadSub ths1 = new ThreadSub("���", "��", 1); 
		ths1.start(); // th1 ����
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {}
		
		ThreadSub ths2 = new ThreadSub("����", "��", 5);
		ths2.start(); // th2 ����
		try {
			Thread.sleep(100); 
		} catch(InterruptedException e) {}
		
		ThreadSub ths3 = new ThreadSub("��ȣ", "��", 4);
		ths3.start(); // th2 ����
		try {
			Thread.sleep(300); // main�� �������� �ʱ� ���� 
		} catch(InterruptedException e) {}

	}
}
