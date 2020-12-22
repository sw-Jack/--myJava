class ThisEx {
	String name, idnum, tel;
	public ThisEx() {
		this.name = "Guest";
		this.idnum = "000000-0000000";
		tel = "000-0000-0000";
	}
	public ThisEx(String name) {
		this();
		this.name = name;
	}
	public ThisEx(String name, String idnum) {
		this(name);
		this.idnum = idnum;
	}
	public ThisEx(String name, String idnum, String tel) {
		this(name, idnum);
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public String getIdnum() {
		return idnum; 
	}
	public String getTel() {
		return tel;
	}
}
public class ThisEx1 {
	public static void main(String[] args) {
		ThisEx ref = new ThisEx();
		System.out.println("Name : " + ref.getName());
		System.out.println("Idnum : " + ref.getIdnum());
		System.out.println("Tel : " + ref.getTel());
	}
}
