// StringTokenizer Ŭ���� �ǽ� : StringTokenizer�� split() �Լ��� ����
import java.util.StringTokenizer;
public class StringTokenEx2 { 
	public static void main(String[] args) {
		String str = "�б�, ��,,���ӹ�";

		// StringTokenizer
		StringTokenizer tokens = new StringTokenizer(str, ",");
		for(int i=1; tokens.hasMoreTokens(); i++) {
			System.out.print("����" + i + " = " + tokens.nextToken() + "\t");
		}
		System.out.println();
		System.out.println("===============================================================");

		// split() �Լ�
		String[] values = str.split(",");
		for(int i=0; i<values.length; i++) {
			System.out.print("����" + (i+1) + " = " + values[i] + "\t");
		}
		System.out.println();
	}
}

// StringTokenizer : ���ǹ��� ������ �����ϰ� ����
// split() �Լ� : ���鵵 ����, �� ä�� ���