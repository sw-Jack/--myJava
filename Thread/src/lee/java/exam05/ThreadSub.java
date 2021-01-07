package lee.java.exam05;

public class ThreadSub extends Thread {

	private String name;
	private String lastName;
	
	public ThreadSub(String a, String b, int x) {
		name = a;
		lastName = b;
		// Thread.start() ������ �����ؾ� �� �ΰ��� setPriority(), setDaemon()
		setPriority(x); // �켱����
		setDaemon(true); // Daemon Thread : main ����� thread�� ����
	}
	
	public void run() {
		System.out.println(Thread.activeCount());
		int xx = Thread.activeCount();
		Thread[] th = new Thread[xx];
		Thread.enumerate(th); // ������ ���� ���� **
		for(int i=0; i<th.length; i++) {
			System.out.println(th[i].getName() + " : " + th[i].getPriority()
					+ " : "  + th[i].isDaemon() + " : " + th[i].isAlive());
		}
		
		while(true) {
			System.out.println("�̸� : " + name);
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				System.err.println("\t�̸�2 : " + lastName);
			}
		}
	}
}
