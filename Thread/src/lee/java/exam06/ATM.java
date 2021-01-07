package lee.java.exam06;

public class ATM implements Runnable {

	private long deposit = 10000;
	
	@Override
	public void run() {
		// 동기화 
		synchronized(this) {
			for(int i=0; i<10; i++) {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				//if(getDeposit() <= 0) break; 를 추가하면 완전한 시스템 (처리 과정을 보기 위해 주석처리)
				withDraw(1000);
			}
		}
	}
	
	public long getDeposit() {
		return deposit;
	}
	
	public void withDraw(long need) {
		if(getDeposit() > 0) {
			deposit -= need;
			System.out.println(Thread.currentThread().getName() + ", ");
			System.out.printf("잔액 : %d원\n", getDeposit());
		} else {
			System.out.println(Thread.currentThread().getName() + ", ");
			System.out.println("잔액이 부족합니다.");
		}
	}
}
