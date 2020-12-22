public class ArrayEx3 {
	public static void main(String[] args) {
		int[][] test;	// 다차원 배열 선언
		test = new int[3][2];
		test[0][0] = 100;
		test[0][1] = 200;
		//--------------------- 1행
		test[1][0] = 300;
		test[1][1] = 400;
		//--------------------- 2행
		test[2][0] = 500;
		test[2][1] = 600;
		//--------------------- 3행
		// System.out.println(test.length + "," + test[1].length);
		for(int i=0; i<test.length; i++) {
			for(int j=0; j<test[i].length; j++) {
					System.out.print("test[" + i + "][" + j + "] = " + test[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
