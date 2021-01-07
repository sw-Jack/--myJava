package lee.java.exam04;

public class MyRunnable2 implements Runnable {

	@Override
	public void run() {
		System.out.println("run");
		first();
	}

	public void first() {
		System.out.println("first");
		second();
	}
	
	public void second() {
		System.out.println("second");
	}
}
