public class GenericExMain {
	public static void main(String[] args) {
		GenericEx<String> t = new GenericEx<String> ();
		String[] ss = {"��", "��", "��"};
		t.set(ss);
		t.print();
	}
}