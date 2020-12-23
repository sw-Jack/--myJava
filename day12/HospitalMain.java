class Hospital {
	// �޼���
	public void inject(Animal animal) {
		System.out.println(animal.getName() + "��(��) ġ���ϱ� ���� �ֻ縦 ���ҽ��ϴ�.");
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