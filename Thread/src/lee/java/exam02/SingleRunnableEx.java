package lee.java.exam02;

// Runnable interface를 상속 받아 구현
public class SingleRunnableEx implements Runnable {
	private int temp[];
	public SingleRunnableEx() {
		temp = new int[10];
		for(int start=0; start<10; start++) {
			temp[start] = start;
		}
	}
	
	@Override
	public void run() {
		for(int start : temp) {
			try { 
				Thread.sleep(1000); // 해당 클래스는 자체가 Thread가 아니고 Runnable 이므로 Thread.sleep()
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("스레드 이름 : %s, ", Thread.currentThread().getName());
			System.out.printf("temp value : %d\n", start);
		}
	}
	
	public static void main(String[] args) {
		SingleRunnableEx runnable = new SingleRunnableEx();
		// Runnable은 자체적으로 run() 메서드를 실행할 수 없으므로 Thread 생성시 매개변수에
		// runnable 객체를 실어 생성 -> 따라서 start() 메서드 사용이 가능해져 start() 호출 후 run() 호출
		Thread thread = new Thread(runnable, "첫번째");
		thread.start();
	}

}
