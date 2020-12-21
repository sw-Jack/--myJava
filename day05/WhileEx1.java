public class WhileEx1 {	// 1~100까지 합 구하기
	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		while(i < 100) {
			i++; 
			sum += i;
		}
		System.out.println("1부터 100까지의 합은 " + sum);


		sum = 0;
		// for문으로 변경
		for(int j=1; j<= 100; j++) {
			sum += j;
		}
		System.out.println("1부터 100까지의 합은 " + sum);
	}
}
