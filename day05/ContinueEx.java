public class ContinueEx {
	public static void main(String[] args) {
		for(int i=0; i<=20; i++) {
			if(i % 2 == 0) continue;
			System.out.println(i); // 홀수만 출력한다..
		}
		System.out.println("");
	}
}
