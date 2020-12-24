// StringBuffer 클래스 실습
public class StringBufferEx1 {
	public static void main(String[] args) {
		// 비어있는 StringBuffer 객체를 생성하고 초기값으로 문자 16개를
		// 기억하고 있는 용량을 가짐. 문자를 쓰게 되면 크기는 (16 + 해당 문자열 길이)
		StringBuffer sb = new StringBuffer("JAVA");
		sb.append("1.6"); // 뒤에 이어 붙이기
		System.out.println(sb);
		
		sb.delete(3, 5); // 인덱스 3, 4 삭제
		System.out.println(sb);
		
		sb.insert(3, "A1"); // 인덱스 3에 A1 삽입
		System.out.println(sb);
		
		sb.replace(4, 7, "일점육"); // 인덱스 4, 5, 6 "일점육"으로 대체
		System.out.println(sb);
		
		sb.reverse(); // 뒤집기
		System.out.println(sb);
	}
}
