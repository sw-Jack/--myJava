class MethodEx {
	// 멤버필드
	// 생성자 - default 생성자 public MethodEx() { }
	// 메서드
	public int sum(int i, int j) {
		return i + j;
	}
	public int sub(int i, int j) {
		return i - j;
	}
	public int mul(int i, int j) {
		return i * j;
	}
	public int div(int i, int j) {
		return i / j;
	}
}
	
public class MethodExOne {  
	public static void main(String[] args) {
		MethodEx ref = new MethodEx();	// 객체 생성, 객체.메서드
		int i = 10;
		int j = 10;
		
		System.out.println("더한 값 : " + ref.sum(i,j));
		System.out.println("뺀 값 : " + ref.sub(i,j));
		System.out.println("곱한 값 : " + ref.mul(i,j));
		System.out.println("나눈 값 : " + ref.div(i,j));
	}
}
