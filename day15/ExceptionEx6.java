// 예외 처리 실습
// finally를 포함한 예외 처리
public class ExceptionEx6 {
	int[] ss;
	public ExceptionEx6() {
		ss = new int[3]; // 속성(멤버필드) 초기화
	}

	public void program() {
		for(int i=0; i<=ss.length; i++) {
			System.out.println("for문의 시작 " + i + "번째");
			try {
				System.out.println(ss[i]);
			} catch(Exception e) {
				System.out.println("Exception 발생 : " + e.toString());
				return;
			} finally{ 
				System.out.println("finally 영역");
			}
			System.out.println("for문의 끝 " + i + "번째"); // 앞에서 예외 발생시 해당 문장 실행 Xx
		}
	}
	public static void main(String[] args) {
		ExceptionEx6 ref = new ExceptionEx6();
		ref.program();
		System.out.println("프로그램 끝!");
	}
}
