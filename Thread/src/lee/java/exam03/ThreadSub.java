package lee.java.exam03;

// Thread : 병행 처리 가능
// Thread 활용 예제 : A가 먼저 찍힐까 1이 먼저 찍힐까
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
