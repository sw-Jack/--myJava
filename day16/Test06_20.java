public class Test06_20 {
	public static void main(String[] args) {
		for(int i=0; i<15; i++) {
			char alpha = (char)((int)(Math.random() * 26) + 65);
			System.out.print(alpha + "\t");
			if((i+1)%5 == 0) 
				System.out.println();
		}
	}
}
