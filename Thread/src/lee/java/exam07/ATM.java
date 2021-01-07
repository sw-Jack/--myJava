package lee.java.exam07;

public class ATM implements Runnable {

	private long deposit = 10000;
	
	@Override
	public void run() {
		synchronized (this) {
			for(int i=0; i<10; i++) {
				if(getDeposit() <= 0) break;
				withDraw(1000);
				// 2/4/6/8 천원이 되면 다른 실행중이던 Thread는 wait(), 중지하고
				if(getDeposit() == 2000 || 
						getDeposit() == 4000 ||
							getDeposit() == 6000 ||
								getDeposit() == 8000) {
					try {
						this.wait(); // 나 잠깐 쉴게.. 실행 대기중이던 애, 너 차례야!
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					this.notify(); // 다음 차례 실행 준비(대기)해!
				}
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
