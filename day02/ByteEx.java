public class ByteEx {
	public static void main(String[] args) {
		// 자바에서는 초기화할 때 그 자료의 표현 범위를 초과할 수 없다.
		// byte bb = 128l -> Error!
		byte bb = 127; // byte : -128 ~ 127
		

		
		// 연산 시에는 범위에서 벗어나도 에러는 나지 않는다. 
		bb++; // bb = bb + 1; // bb += 1;
		System.out.println("byte bb = " + bb);
	}
}
