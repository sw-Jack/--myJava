public class ByteEx {
	public static void main(String[] args) {
		// �ڹٿ����� �ʱ�ȭ�� �� �� �ڷ��� ǥ�� ������ �ʰ��� �� ����.
		// byte bb = 128l -> Error!
		byte bb = 127; // byte : -128 ~ 127
		

		
		// ���� �ÿ��� �������� ����� ������ ���� �ʴ´�. 
		bb++; // bb = bb + 1; // bb += 1;
		System.out.println("byte bb = " + bb);
	}
}
