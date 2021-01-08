import java.awt.*;
import java.applet.*;

public class ParamEx extends Applet {
	String name;
	String phone;
	String email;

	public void init() {
		name = getParameter("name");
		if(name == null) name = "홍길동";

		phone = getParameter("phone");
		if(phone == null) phone = "010-1111-1111";

		email = getParameter("email");
		if(email == null) email = "paramEx@never.com";
	}

	public void paint(Graphics g) {
		g.setFont(new Font("Sans-Serif", Font.ITALIC, 25));
		g.drawString("이름 : " + name, 50, 100);
		g.drawString("전화 : " + phone, 50, 150);
		g.drawString("이메일 : " + email, 50, 200);
	}
}