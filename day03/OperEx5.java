public class OperEx5 {
	public static void main(String[] args) {
		boolean a;
		boolean b;
		// if((a = 4 > 3) || (b = 5 > 7)) { // short circuit 현상 : && || 와 같은 논리 연산자는
										 // 앞에서 연산의 결과가 결정났을 경우 뒤의 불필요한 연산은 
										 // 진행하지 않음. 따라서 b는 초기화되지 않기 때문에 Error!!
										 
		if((a = 4 > 3) | (b = 5 > 7)) {  // 따라서 이럴 땐 %& | 와 같은 비트 연산자를 사용해야함 
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			}
	}
}
