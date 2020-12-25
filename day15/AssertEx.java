// assert 실습
/* 실행법 : "java -ea [클래스명] [인자]" dhq
 * 옵션 (옵션을 명시하지 않으면 -da가 기본)
	-ea : Enable Assertions
	-da : Disable Assertions
*/
public class AssertEx {
	public void gugu(int dan) {
		// 아래의 assert문의 조건을 만족하지 못하면 오른쪽 문구 출력(message)
		assert dan > 1 && dan < 10 : "2 ~ 9단 중 하나를 입력하세요.";
		System.out.println(dan + "단");
		System.out.println("===================");
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<9; i++) {
			sb.delete(0, sb.length());
			sb.append(dan); sb.append("*"); sb.append(i+1);
			sb.append("="); sb.append(dan*(i+1));
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		AssertEx at = new AssertEx();
		try {
			int dan = Integer.parseInt(args[0]);
			at.gugu(dan);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
