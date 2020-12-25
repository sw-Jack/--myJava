// assert �ǽ�
/* ����� : "java -ea [Ŭ������] [����]" dhq
 * �ɼ� (�ɼ��� ������� ������ -da�� �⺻)
	-ea : Enable Assertions
	-da : Disable Assertions
*/
public class AssertEx {
	public void gugu(int dan) {
		// �Ʒ��� assert���� ������ �������� ���ϸ� ������ ���� ���(message)
		assert dan > 1 && dan < 10 : "2 ~ 9�� �� �ϳ��� �Է��ϼ���.";
		System.out.println(dan + "��");
		System.out.println("===================");
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<9; i++) {
			sb.delete(0, sb.length());
			sb.append(dan); sb.append("*"); sb.append(i+1);
			sb.append("="); sb.append(dan*(i+1));
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		AssertEx at = new AssertEx();
		try {
			int dan = Integer.parseInt(args[0]);
			at.gugu(dan);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
