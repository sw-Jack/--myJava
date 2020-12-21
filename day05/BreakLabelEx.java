public class BreakLabelEx {
	public static void main(String[] args) {
		One : for(int i=0; i<5; i++) {
			Two : for(int j=0; j<3; j++) {
				if (j == 2) break One;
				System.out.print(j + "x" + i + " ");
			}
		}
		System.out.println();
	}
}
