public class ForEx3 {
	public static void main(String[] args) {
		String [] arr = {"AA", "BB", "CC", "DD", "EE"};
		for(String s : arr) {
			System.out.println("배열의 값들은 ? " + s);
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println("배열의 값들은 ? " + arr[i]);
		}
	}
}
