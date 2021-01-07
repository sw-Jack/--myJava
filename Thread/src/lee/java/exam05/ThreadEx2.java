package lee.java.exam05;

public class ThreadEx2 {

	public static void main(String[] args) {
		ThreadSub ths1 = new ThreadSub("흥민", "손", 1); 
		ths1.start(); // th1 실행
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {}
		
		ThreadSub ths2 = new ThreadSub("지성", "박", 5);
		ths2.start(); // th2 실행
		try {
			Thread.sleep(100); 
		} catch(InterruptedException e) {}
		
		ThreadSub ths3 = new ThreadSub("찬호", "박", 4);
		ths3.start(); // th2 실행
		try {
			Thread.sleep(300); // main을 종료하지 않기 위해 
		} catch(InterruptedException e) {}

	}
}
