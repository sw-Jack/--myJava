/**
	싱글톤 : Singleton = 객체를 하나만. 어디서든 접근 가능. 그러나 하나를 동시에 여럿이 접근은 불가능
*/
public class MySingleton {
	// 멤버
	private static MySingleton instance;
	// 생성자
	private MySingleton() {
	}
	// 메서드
	public static MySingleton getInstance() {
		if(instance == null) {
			// synchronized() : 동기화 메서드 
			// -> 두개 이상의 쓰레드가 하나의 자원을 공유할 때 자원을 보호하기 위해 사용.
			// -> 공유 자원에 접근할 때 다른 쓰레드가 접근하지 못하도록 해당 자원을 잠금(lock)해버리는 기능.
			// 자원 사용이 끝나면 unlock해여 다른 쓰레드가 접근 가능할 수 있도록 함.
			synchronized(MySingleton.class) {
				instance = new MySingleton();
			}
		}
		return instance;
	}
}