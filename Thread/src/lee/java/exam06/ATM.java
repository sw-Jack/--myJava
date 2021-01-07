package lee.java.exam06;

public class ATM implements Runnable {

	private long deposit = 10000;
	
	@Override
	public void run() {
		// ����ȭ 
		synchronized(this) {
			for(int i=0; i<10; i++) {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				//if(getDeposit() <= 0) break; �� �߰��ϸ� ������ �ý��� (ó�� ������ ���� ���� �ּ�ó��)
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
			System.out.printf("�ܾ� : %d��\n", getDeposit());
		} else {
			System.out.println(Thread.currentThread().getName() + ", ");
			System.out.println("�ܾ��� �����մϴ�.");
		}
	}
}
