// List 인터페이스 - Stack 실습
import java.util.Stack;

public class StackEx {
	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄","쿠웨이트","사우디","대한민국"};
		Stack<String> stack = new Stack<String>();
		for(String n : groupA)
			stack.push(n);
		while(!stack.isEmpty()) 
			System.out.println(stack.pop());
	}
}

