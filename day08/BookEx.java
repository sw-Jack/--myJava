public class BookEx { // 클래스	// Value Object
	String name;
	String writer;
	int price;
	int nowPage;
	String isbn;	// 멤버 변수

	public BookEx() {	// default 생성자 : 매개 변수가 없는 메서드 
						// 개발자가 생성자를 하나도 만들지 않은 경우(명시되어 있지 않은 경우), JVM이 자동으로 만들어줌
	}	

	public void nextPage() {	// 메서드 
		nowPage++;
	}

	public void previousPage() {	// 메서드 
		nowPage--;
	}

}
