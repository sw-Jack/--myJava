public class MethodExThree { 
	int var; // ��� �ʵ�
	// ������
	// �޼���
	public void setVar(int var) {
		this.var = var;	// var = var; �� �Է½� ���� ������ ���� ������ ������ ��ȣ������ ������ ������ �߻��Ѵ�. 
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

// - ���� ������ ���� ������ ��ġ�� ���������� ���� ������ �켱�Ѵ�. �׷� ���� ������ �̾߱��Ϸ���???