// StringTokenizer Ŭ���� �ǽ�
import java.util.StringTokenizer;
public class StringTokenEx1 {
	// ������� StringTokenize ��ü st
	StringTokenizer st;

	// ������
	public StringTokenEx1(String str) {
		System.out.println("str : " + str);
		st = new StringTokenizer(str);
	}
	public StringTokenEx1(String str, String delim) { // delim : ������
		System.out.println("str : " + str);
		st = new StringTokenizer(str, delim);
	}
	
	// �޼���
	public void print() {
		System.out.println("Tokent count : " + st.countTokens()); // countTokens() : token�� �ڿ��� �� ��ȯ
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println("===============================================");
	}

	public static void main(String[] args) {
		StringTokenEx1 st1 = new StringTokenEx1("Happy day");
		st1.print();
		StringTokenEx1 st2 = new StringTokenEx1("2005/08/15", "/");
		st2.print();
	}
}