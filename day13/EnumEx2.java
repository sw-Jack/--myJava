// 열거형 enum 예제
public class EnumEx2 {
	public enum Item {
		add, del, search, cancel // 열거형 상수들
	}
	
	public static void main(String[] args) {
		Item item = Item.search;

		if(item instanceof Object) { // 열거형이 Object(객체)인지 아닌지 비교
			System.out.println(item.toString() + "^^");
			System.out.println("Right! instanceof Object");
			System.out.println("저장된 실제 정수값 : " + item.ordinal());
			// ordinal() 함수 : 열거형에서 열거형 상수들을 0에서 부터 차례대로 번호를 매겨 해당값을 출력
		}
		Item[] items = Item.values();
		System.out.println("items.length : " + items.length);
	}
}