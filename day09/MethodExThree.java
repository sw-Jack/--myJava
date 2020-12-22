public class MethodExThree { 
	int var; // 멤버 필드
	// 생성자
	// 메서드
	public void setVar(int var) {
		this.var = var;	// var = var; 로 입력시 전역 변수와 지역 변수의 구분이 모호해지기 때문에 문제가 발생한다. 
	}
	public int getVar() {
		return var;
	}
	public static void main(String[] args) {
		MethodExThree me = new MethodExThree();
		me.setVar(1000);
		System.out.println("var : " + me.getVar());
	}
}

// - 전역 변수와 지역 변수가 겹치는 영역에서는 지역 변수가 우선한다. 그럼 전역 변수를 이야기하려면???