package lee.java.exam06;

// <����ȭ Ȱ�� ����> : synchronized
//����ȭ���� ���� ���� �ʾ��� �� ��� ��
//- ����ȭ ���� ��  : mother Thread ���� ���� 10���� ���� 10000���� ��� �����ϹǷ� 
//				 mohter Thread ���� ���� �����son Thread�� ��������� �ܾ� �������� 
//	             10���� ����
//- ����ȭ���� �ʾ��� �� : ���׹���
public class SynchronizedEx {

	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		mother.start();
		son.start();
	}
}
