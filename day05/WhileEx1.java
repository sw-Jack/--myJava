public class WhileEx1 {	// 1~100���� �� ���ϱ�
	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		while(i < 100) {
			i++; 
			sum += i;
		}
		System.out.println("1���� 100������ ���� " + sum);


		sum = 0;
		// for������ ����
		for(int j=1; j<= 100; j++) {
			sum += j;
		}
		System.out.println("1���� 100������ ���� " + sum);
	}
}
