package lee.java.test01;
import java.util.Random;

public class PrimeNumber {
	public static void main(String[] args) {
		int count = 100; // ���� ���� ���� 
		int arr[] = new int[count]; // ���� ������ ��
		int minRandNum = 1; // �Ƽ� ������ �ּҰ� : ������ �� ���� -> �ִ� �Ҽ��� ���� ���ϱ� ����
		int maxRandNum = 1000; // �Ƽ� ������ �ִ밪 : ������ �� ���� -> �ּ� �Ҽ��� ���� ���ϱ� ����
		Random random = new Random();
		
		// �ߺ� ���� ���� ����
		for(int i=0; i<count; i++) {
			arr[i] = random.nextInt(maxRandNum) + minRandNum; // ���� ���� : 1 ~ 1000
			for(int j=0; j<i; j++) { // i��° ���� 0~(i-1)��° ����� ���� 
				if(arr[i] == arr[j]) // ���ٸ� 
					i--;// �ε��� �ڷ�, �� �ٽ� ���� �����
			}
		}
		
		System.out.println("===========================\n"
					+ "�̷�ũ���� �Ҽ� �Ǵ� ���α׷�\n\t- ȫ�浿\n" 
					+ "===========================");
		
		int primeNumCnt = 0; // ��µ� �Ҽ� ����
		int maxPrimeNum = minRandNum; // �ִ� �Ҽ� -> �ʱⰪ�� �߻� ���� ������ �ּҰ����� ����
		int minPrimeNum = maxRandNum; // �ּ� �Ҽ� -> �ʱⰪ�� �߻� ���� ������ �ִ밪���� ����
		// ������ ���� 100�� �߿��� �Ҽ� ����ϱ�
		for(int i=0; i<count; i++) {
			int divisorCnt = 0; // ����� ���� �ʱ�ȭ
			for(int j=arr[i]; j>=1; j--) {
				// 1���� �ڱ��ڽű��� ���������� �� �������� 0�� ���, �� ����� ��, ��� ���� +1
				if(arr[i]%j == 0) divisorCnt++; 
			}
			if(divisorCnt == 2) { // ����� ������ 2��(1�� �ڽ�)�̸� �Ҽ��� �Ǵ�
				System.out.println("�Ҽ� �߰� : " + arr[i]); // �ش� �Ҽ� ���
				primeNumCnt++; // �Ҽ� ���� +1
				// ���� �Ҽ��� max ������ ũ�� �ش� �Ҽ��� max������ ����
				if(arr[i] > maxPrimeNum) maxPrimeNum = arr[i]; 
				// ���� �Ҽ��� min ������ ������ �ش� �Ҽ��� min������ ����
				if(arr[i] < minPrimeNum) minPrimeNum = arr[i];
			}
		}
		// ���� ��� ���
		System.out.println("---------------------------\n���� ��� :");
		System.out.println("�Ҽ� ���� : " + primeNumCnt);
		System.out.println("�ּ� �Ҽ� : " + minPrimeNum);
		System.out.println("�ִ� �Ҽ� : " + maxPrimeNum);
		System.out.println("===========================");
	}
}


