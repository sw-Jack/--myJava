class Animal {
	// 메서드
	public String scream() {
		return "동물 울음 소리";
	}
	// getter 메서드
	public String getName(){
		return null;
	}
}

class Dog extends Animal {
	// 멤버
	private String name;
	// default 생성자
	public Dog() {
		name = getClass().getSimpleName();
	}
	// 오버라이딩 // 메서드
	public String scream() {
		return "멍멍꺠깽";
	}
	// getter 메서드
	public String getName() {
		return name;
	}
}

class Cat extends Animal {
	// 멤버
	private String name;
	// default 생성자
	public Cat() {
		name = getClass().getSimpleName();
	}
	// 오버라이딩 // 메서드
	public String scream() {
		return "야옹야옹";
	}
	// getter 메서드
	public String getName() {
		return name;
	}
}

class Tiger extends Animal {
	// 멤버
	private String name;
	// default 생성자
	public Tiger() {
		name = getClass().getSimpleName();
	}`
	// 오버라이딩 // 메서드
	public String scream() {
		return "크허헝";
	}
	// getter 메서드
	public String getName() {
		return name;
	}
}
