package lee.java.exam07;

// Thread 간 협업 (wait() / notify() / notifyAll()) : 번갈아가며 교대로 실행
// - wait() : 해당 스레드를 일시 정지 상태로 만듦
// - notify() : 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태로 만듦
public class WaitNotifyEx {
	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		mother.start();
		son.start();		
	}
}
