public class ArrayEx7 {
	public static void main(String[] args) {
		String[] src = {"Java", "Database", "JSP", "XML"};
		String[] des = new String[6];

		des[0] = "OS";
		des[1] = "Network";

		System.arraycopy(src, 0, des, 2, 4);
		for(String temp : des)
			System.out.println("des vale : " + temp);
	}
}
