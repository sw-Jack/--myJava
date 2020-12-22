public class BookTest {  
	public static void main(String[] args) {
		BookEx mybook = new BookEx();
		mybook.name = "java programming";
		mybook.writer = "Tommy. Lee";
		mybook.price = 0;
		mybook.isbn = "KG Eduone ITBank";
		mybook.nowPage = 45;

		mybook.nextPage();
		System.out.println(mybook.writer + "님은 " + mybook.name + " 책을 " + mybook.nowPage + "페이지까지 읽으셨습니다.");
	}
}
