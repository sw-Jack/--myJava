// StringBuffer Ŭ���� �ǽ�
public class StringBufferEx1 {
	public static void main(String[] args) {
		// ����ִ� StringBuffer ��ü�� �����ϰ� �ʱⰪ���� ���� 16����
		// ����ϰ� �ִ� �뷮�� ����. ���ڸ� ���� �Ǹ� ũ��� (16 + �ش� ���ڿ� ����)
		StringBuffer sb = new StringBuffer("JAVA");
		sb.append("1.6"); // �ڿ� �̾� ���̱�
		System.out.println(sb);
		
		sb.delete(3, 5); // �ε��� 3, 4 ����
		System.out.println(sb);
		
		sb.insert(3, "A1"); // �ε��� 3�� A1 ����
		System.out.println(sb);
		
		sb.replace(4, 7, "������"); // �ε��� 4, 5, 6 "������"���� ��ü
		System.out.println(sb);
		
		sb.reverse(); // ������
		System.out.println(sb);
	}
}
