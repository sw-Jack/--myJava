abstract class Unit { // 추상 클래스 선언
	int x, y;

	// 추상 메서드 : 공통 기능들
	abstract void move(int x, int y);
	abstract void stop();
	abstract void message();
}

// 마린 클래스
class Marine extends Unit {
	// 오버라이딩 
	void move(int x, int y) {
		System.out.println("Go go!\n[마린의 위치] 이동 좌표 : x = " + x + ", y = " + y);
	}
	void stop() {
		System.out.println("마린이 대기 상태에 있습니다");
	}
	void message() {
		System.out.println("Message :: Standing back!");
	}
	// 해당 클래스 고유 메서드
	void stimPack() {
		System.out.println("마린이 스팀팩을 사용한다.");
	}
}

// 시저 탱크 클래스
class SiegeTank extends Unit {
	// 오버라이딩 
	void move(int x, int y) {
		System.out.println("Move it! Move it!\n[시저탱크 위치] 이동 좌표 : x = " + x + ", y = " + y);
	}
	void stop() {
		System.out.println("Destination?");
	}
	void message() {
		System.out.println("Message :: Go, Siege!");
	}
	// 해당 클래스 고유 메서드
	void changeMode() {
		System.out.println("Yes, Sir!");
	}
}

// 드랍쉽 클래스
class Dropship extends Unit {
	// 오버라이딩 
	void move(int x, int y) {
		System.out.println("Take it slow. Dropship\n[드랍쉽 위치] 이동 좌표 : x = " + x + ", y = " + y);
	}
	void stop() {
		System.out.println("In the by, by, by, by");
	}
	void message() {
		System.out.println("Message :: Can I take orders?");
	}
}

public class UseGame {
	public static void main(String[] args) {
		Unit[] ref = new Unit[3];
		ref[0] = new Marine();
		ref[1] = new SiegeTank();
		ref[2] = new Dropship();

		for(int i=0; i<ref.length; i++) {
			System.out.println("===================================");
			ref[i].move(100,200);
			ref[i].message();
			System.out.println("===================================");
		}
	}
}

