public class VariableEx {
	public void argTest(String ... n) {	// �迭 ���� free
		for(int i=0; i<n.length; i++) 
			System.out.println("n[" + i + "] : " + n[i]);
		System.out.println("-------------------------------");
	}

	public static void main(String[] args) {
		VariableEx ve = new VariableEx();
		ve.argTest("Varargs", "Test");	
		ve.argTest("100", "600", "900", "1000"); // ���ϴ� ��� String �迭 ���� ����
	}
}	// public void argTest(String str1, String str2,) { ... }
	// public void argTest(String a, String b, String c, String d) { ... }
	// �׷��ٸ� ... ���� �̸��� �޼��带 ������ ���� �� �ֳ�???