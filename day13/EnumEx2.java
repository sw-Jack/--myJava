// ������ enum ����
public class EnumEx2 {
	public enum Item {
		add, del, search, cancel // ������ �����
	}
	
	public static void main(String[] args) {
		Item item = Item.search;

		if(item instanceof Object) { // �������� Object(��ü)���� �ƴ��� ��
			System.out.println(item.toString() + "^^");
			System.out.println("Right! instanceof Object");
			System.out.println("����� ���� ������ : " + item.ordinal());
			// ordinal() �Լ� : ���������� ������ ������� 0���� ���� ���ʴ�� ��ȣ�� �Ű� �ش簪�� ���
		}
		Item[] items = Item.values();
		System.out.println("items.length : " + items.length);
	}
}