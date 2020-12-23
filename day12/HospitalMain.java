class Hospital {
	// 메서드
	public void inject(Animal animal) {
		System.out.println(animal.getName() + "을(를) 치료하기 위해 주사를 놓았습니다.");
		System.out.println(animal.scream());
	}
}


public class HospitalMain {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal tiger = new Tiger();
		hospital.inject(dog);
		hospital.inject(cat);
		hospital.inject(tiger);
	}
}