public class OperEx3 {
	public static void main(String[] args) {
		int i = 12; // i�� n�� ��,
		int j = i << 2; // j = i * (2^n)
		int k = i >> 2; // j = i * (2^-n) // ����Ʈ�ϰ� ��ȣ�� ���� �� ���ڸ� ����, ����� 0 / ������ 1
		int m = i >>> 2; // ����Ʈ�ϰ� ��ȣ ������� �������� �� 0����

		System.out.println("i = " + i + ", j = " + j + ", m = " + k + ", m = " + m);
	}
}
