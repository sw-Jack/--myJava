public class ArrayEx5 {
	public static void main(String[] args) {
		int[][] test;	// ������ �迭 ����

		test = new int[3][];

		test[0] = new int[2];	// 1�� �ʱ�ȭ
		test[1] = new int[1];	// 2�� �ʱ�ȭ
		test[2] = new int[3];	// 3�� �ʱ�ȭ

		test[0][0] = 100;
		test[0][1] = 200;
		//------------------- 1�� ��
		test[1][0] = 300;
		//------------------- 2�� ��
		test[2][0] = 400;
		test[2][1] = 500;
		test[2][2] = 600;
		//------------------- 1�� ��

		for(int i=0; i<test.length; i++) {
			for(int j=0; j<test[i].length; j++) {
				System.out.print("test[" + i + "][" + j + "] = " + test[i][j] + "\t");
			}
			System.out.println();
		}

	}
}