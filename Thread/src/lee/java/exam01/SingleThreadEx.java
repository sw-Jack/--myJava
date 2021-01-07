package lee.java.exam01;

// Thread 클래스를 상속 받아 구현
public class SingleThreadEx extends Thread {
	private int[] temp;
	
	public SingleThreadEx(String threadName) {
		super(threadName);
		temp = new int[10];
		for(int start=0; start<temp.length; start++) {
			temp[start] = start;
		}
	}
	
	public void run() {
		for(int start : temp) {
			try {
				sleep(1000); // 해당 클래스 자체가 Thread 이기 때문에 Thread.sleep() X
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("스레드 이름 : %s, ", currentThread().getName());
			System.out.printf("temp value : %d\n", start);
		}
	}
	public static void main(String[] args) {
		SingleThreadEx st = new SingleThreadEx("첫번째");
		st.start(); // 2
		// st.run(); 으로 실행했을 경우는 순차 실행 run() -> sysout
		System.out.println("순서 비교하기"); // 1 => 병행 처리 !!
		
	}

}
