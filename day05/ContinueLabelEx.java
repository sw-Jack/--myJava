public class ContinueLabelEx {
	public static void main(String[] args) {
		F1 : for(int i=0; i<5; i++) {
			F2 : for(int j=0; j<3; j++) {
				if(j == 1) {
					continue F1;
				}
				System.out.print(j + " x " + i + "  ");
			}
		}
		System.out.println("");
	}
}
