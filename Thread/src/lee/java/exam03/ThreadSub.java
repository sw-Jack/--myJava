package lee.java.exam03;

// Thread : ���� ó�� ����
// Thread Ȱ�� ���� : A�� ���� ������ 1�� ���� ������
public class ThreadSub extends Thread {
	public void run() {
		for(char ch = 'A'; ch <= 'z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(150);
			} catch(InterruptedException e) {}
		}
	}
}
