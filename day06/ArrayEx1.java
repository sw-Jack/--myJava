public class ArrayEx1 {
	public static void main(String[] args) {
		char[] ch;	// �迭 ����
		ch = new char[4];	// �迭 �ʱ�ȭ
		
		// �迭 �� �Ҵ�
		ch[0] = 'J';
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';

		// �迭 ���� ���
		for(int i=0; i<ch.length; i++) 
			System.out.println("ch[" + i + "] : = " + ch[i]);
		//���� for ��
		int j=0;
		for(char temp : ch) { // ch�� �ִ� ��ġ�� Series ���� �´�.
			System.out.println("temp " + j + " : " + temp);
			j++;
		}
	}
}