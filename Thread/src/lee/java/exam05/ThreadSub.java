package lee.java.exam05;

public class ThreadSub extends Thread {

	private String name;
	private String lastName;
	
	public ThreadSub(String a, String b, int x) {
		name = a;
		lastName = b;
		// Thread.start() 이전에 설정해야 할 두가지 setPriority(), setDaemon()
		setPriority(x); // 우선순위
		setDaemon(true); // Daemon Thread : main 종료시 thread도 종료
	}
	
	public void run() {
		System.out.println(Thread.activeCount());
		int xx = Thread.activeCount();
		Thread[] th = new Thread[xx];
		Thread.enumerate(th); // 스레드 정보 저장 **
		for(int i=0; i<th.length; i++) {
			System.out.println(th[i].getName() + " : " + th[i].getPriority()
					+ " : "  + th[i].isDaemon() + " : " + th[i].isAlive());
		}
		
		while(true) {
			System.out.println("이름 : " + name);
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				System.err.println("\t이름2 : " + lastName);
			}
		}
	}
}
