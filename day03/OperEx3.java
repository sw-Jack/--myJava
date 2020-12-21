public class OperEx3 {
	public static void main(String[] args) {
		int i = 12; // i가 n일 때,
		int j = i << 2; // j = i * (2^n)
		int k = i >> 2; // j = i * (2^-n) // 시프트하고 부호에 따라 맨 앞자리 변경, 양수면 0 / 음수면 1
		int m = i >>> 2; // 시프트하고 부호 상관없이 나머지를 다 0으로

		System.out.println("i = " + i + ", j = " + j + ", m = " + k + ", m = " + m);
	}
}
