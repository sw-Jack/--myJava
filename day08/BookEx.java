public class BookEx { // Ŭ����	// Value Object
	String name;
	String writer;
	int price;
	int nowPage;
	String isbn;	// ��� ����

	public BookEx() {	// default ������ : �Ű� ������ ���� �޼��� 
						// �����ڰ� �����ڸ� �ϳ��� ������ ���� ���(��õǾ� ���� ���� ���), JVM�� �ڵ����� �������
	}	

	public void nextPage() {	// �޼��� 
		nowPage++;
	}

	public void previousPage() {	// �޼��� 
		nowPage--;
	}

}
