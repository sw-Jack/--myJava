package lee.java.exam02;

// Runnable interface�� ��� �޾� ����
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
				Thread.sleep(1000); // �ش� Ŭ������ ��ü�� Thread�� �ƴϰ� Runnable �̹Ƿ� Thread.sleep()
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("������ �̸� : %s, ", Thread.currentThread().getName());
			System.out.printf("temp value : %d\n", start);
		}
	}
	
	public static void main(String[] args) {
		SingleRunnableEx runnable = new SingleRunnableEx();
		// Runnable�� ��ü������ run() �޼��带 ������ �� �����Ƿ� Thread ������ �Ű�������
		// runnable ��ü�� �Ǿ� ���� -> ���� start() �޼��� ����� �������� start() ȣ�� �� run() ȣ��
		Thread thread = new Thread(runnable, "ù��°");
		thread.start();
	}

}
