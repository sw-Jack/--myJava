public class WriteEx {
	public static void main(String[] args) {
		// write(int), write(byte[]), write(byte[], start, length)
		System.out.write(65); // �빮�� A, 1byte

		// �ڹٿ��� ���۶� 8KByte¥�� ����!
		// 8KByte = 8 * 1024 Byte
		System.out.flush(); // ���ۿ� �ִ� ���� '�ϴ�' ����ض�. 
		System.out.println(); 

		// ����Ʈ �迭 ����� ��쿡�� ���� �÷��� ����� �ִ�.
		byte [] by = {'J', 'A', 'V', 'A'};
		System.out.write(by, 0, 4);
		System.out.println();
	}
}
