public class MethodExTwo {
	int var1, var2;	// 멤버 변수들
	// 생성자 
	public int sum(int a, int b) {	// 메소드(멤버 함수)
		return a + b;
		}
	public static void main(String[] args) {
		MethodExTwo me = new MethodExTwo();
		int res = me.sum(1000, -10);
		System.out.println("res = " + res);
	}
} // 메서드(기능) 돌려받는 반환값을 하나밖에 못 돌려받는다.???