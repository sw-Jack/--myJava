// package 실습
import mypack.pack.MyPackOne;
import mypack.pack.MyPackTwo;

public class MyPackEx {
	public static void main(String[] args) {
		MyPackOne myOne = new MyPackOne();
		myOne.one();
		MyPackTwo myTwo = new MyPackTwo();
		myTwo.two();
	}
}

/* ex) Shop	- database : 데이터베이스 연동 관련 클래스	--> shop.jar
			- util	   : 유틸리티 클래스				--> shop-doc.jar	
			
*/