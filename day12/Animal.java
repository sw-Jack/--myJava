class Animal {
	// �޼���
	public String scream() {
		return "���� ���� �Ҹ�";
	}
	// getter �޼���
	public String getName(){
		return null;
	}
}

class Dog extends Animal {
	// ���
	private String name;
	// default ������
	public Dog() {
		name = getClass().getSimpleName();
	}
	// �������̵� // �޼���
	public String scream() {
		return "�۸ۃƲ�";
	}
	// getter �޼���
	public String getName() {
		return name;
	}
}

class Cat extends Animal {
	// ���
	private String name;
	// default ������
	public Cat() {
		name = getClass().getSimpleName();
	}
	// �������̵� // �޼���
	public String scream() {
		return "�߿˾߿�";
	}
	// getter �޼���
	public String getName() {
		return name;
	}
}

class Tiger extends Animal {
	// ���
	private String name;
	// default ������
	public Tiger() {
		name = getClass().getSimpleName();
	}`
	// �������̵� // �޼���
	public String scream() {
		return "ũ����";
	}
	// getter �޼���
	public String getName() {
		return name;
	}
}
