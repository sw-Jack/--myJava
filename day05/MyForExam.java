public class MyForExam {
	public static void main(String[] args) {
		/*
		for(int i=0; i<5; i++) {	// 회전수 = 카운터
			System.out.println("*");
		}
		*/

		/*
		for(int dan=2; dan<10; dan++) {
			for(int i=1; i<10; i++) {
				System.out.println(dan + "*" + i + "=" + dan*i);
			}
		}
		*/

		/*
		for(int dan=1; dan<10; dan++) {
			for(int i=2; i<10; i++) {
				if(dan*i >= 10) 
					System.out.print(i + "*" + dan + "=" + dan*i + " ");
				else
					System.out.print(i + "*" + dan + "= " + dan*i + " ");
			}
			System.out.println();
		}
		*/
  
		for(int k=1; k<=5; k++) {
			for(int g=0; g<k; g++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
