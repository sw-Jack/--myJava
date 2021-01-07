package lee.java.exam07;

public class ATM implements Runnable {

	private long deposit = 10000;
	
	@Override
	public void run() {
		synchronized (this) {
			for(int i=0; i<10; i++) {
				if(getDeposit() <= 0) break;
				withDraw(1000);
				// 2/4/6/8 õ���� �Ǹ� �ٸ� �������̴� Thread�� wait(), �����ϰ�
				if(getDeposit() == 2000 || 
						getDeposit() == 4000 ||
							getDeposit() == 6000 ||
								getDeposit() == 8000) {
					try {
						this.wait(); // �� ��� ����.. ���� ������̴� ��, �� ���ʾ�!
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					this.notify(); // ���� ���� ���� �غ�(���)��!
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
			System.out.printf("�ܾ� : %d��\n", getDeposit());
		} else {
			System.out.println(Thread.currentThread().getName() + ", ");
			System.out.println("�ܾ��� �����մϴ�.");
		}
	}
}
