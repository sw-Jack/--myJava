package lee.java.exam03;

public class ThreadEx {
	public static void main(String[] args) {
		ThreadSub ts = new ThreadSub();
		ts.start();
		for(int i=1; i<60; i++) {
			System.out.println(i);
			try {
				Thread.sleep(150);
			} catch(InterruptedException e) {}
		}
	}
}
