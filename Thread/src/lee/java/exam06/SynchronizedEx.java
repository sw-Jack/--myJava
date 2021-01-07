package lee.java.exam06;

// <동기화 활용 예제> : synchronized
//동기화했을 때와 하지 않았을 때 결과 비교
//- 동기화 했을 때  : mother Thread 먼저 들어가서 10번에 걸쳐 10000원을 모두 인출하므로 
//				 mohter Thread 종료 이후 실행된son Thread는 실행되지만 잔액 부족으로 
//	             10번을 실행
//- 동기화하지 않았을 때 : 뒤죽박죽
public class SynchronizedEx {

	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		mother.start();
		son.start();
	}
}
