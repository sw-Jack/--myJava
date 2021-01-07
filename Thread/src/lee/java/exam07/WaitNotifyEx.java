package lee.java.exam07;

// Thread �� ���� (wait() / notify() / notifyAll()) : �����ư��� ����� ����
// - wait() : �ش� �����带 �Ͻ� ���� ���·� ����
// - notify() : �Ͻ� ���� ���¿� �ִ� �ٸ� �����带 ���� ��� ���·� ����
public class WaitNotifyEx {
	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		mother.start();
		son.start();		
	}
}
