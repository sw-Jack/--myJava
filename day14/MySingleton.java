/**
	�̱��� : Singleton = ��ü�� �ϳ���. ��𼭵� ���� ����. �׷��� �ϳ��� ���ÿ� ������ ������ �Ұ���
*/
public class MySingleton {
	// ���
	private static MySingleton instance;
	// ������
	private MySingleton() {
	}
	// �޼���
	public static MySingleton getInstance() {
		if(instance == null) {
			// synchronized() : ����ȭ �޼��� 
			// -> �ΰ� �̻��� �����尡 �ϳ��� �ڿ��� ������ �� �ڿ��� ��ȣ�ϱ� ���� ���.
			// -> ���� �ڿ��� ������ �� �ٸ� �����尡 �������� ���ϵ��� �ش� �ڿ��� ���(lock)�ع����� ���.
			// �ڿ� ����� ������ unlock�ؿ� �ٸ� �����尡 ���� ������ �� �ֵ��� ��.
			synchronized(MySingleton.class) {
				instance = new MySingleton();
			}
		}
		return instance;
	}
}