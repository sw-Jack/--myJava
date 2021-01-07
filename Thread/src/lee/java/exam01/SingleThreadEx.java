package lee.java.exam01;

// Thread Ŭ������ ��� �޾� ����
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
				sleep(1000); // �ش� Ŭ���� ��ü�� Thread �̱� ������ Thread.sleep() X
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("������ �̸� : %s, ", currentThread().getName());
			System.out.printf("temp value : %d\n", start);
		}
	}
	public static void main(String[] args) {
		SingleThreadEx st = new SingleThreadEx("ù��°");
		st.start(); // 2
		// st.run(); ���� �������� ���� ���� ���� run() -> sysout
		System.out.println("���� ���ϱ�"); // 1 => ���� ó�� !!
		
	}

}
