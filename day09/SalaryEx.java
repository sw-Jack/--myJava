class Salary {
	private int pay;
	public int getPay() {
		return pay;
	}
	public void setPay(int pay, String pass) {
		if(pass.equals("1234"))
			this.pay = pay;
	}
}
public class SalaryEx {
	public static void main(String[] args) {
		Salary sal = new Salary();
		// sal.pay = 10000;
		// System.out.println("�� ���¸� �������" + sal.pay)
		System.out.println("[After wrong password]");
		sal.setPay(10000,"12345");
		System.out.println("-> �� ���� �ܾ� : " + sal.getPay());

		System.out.println();

		System.out.println("[After right password]");
		sal.setPay(10000,"1234");
		System.out.println("-> �� ���� �ܾ� : " + sal.getPay());
	}
}
