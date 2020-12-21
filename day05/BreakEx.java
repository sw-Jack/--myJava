public class BreakEx {
	public static void main(String[] args) {
		int i = 0 ;
		while(i < 100) {
			System.out.print(" " + i); // String.valueOf(i)
			if(i == 20) break;
			i++;
		}
		System.out.println("");
	}
}
