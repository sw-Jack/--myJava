//Test06_21
class Animal {
	private boolean live;
	private int age;
	private String name;

	public Animal(int age, String name, boolean live) {
		this.name = name;
		this.age = age;
		this.live = live;
	}
	public Animal() {}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public boolean isLive() {
		return live;
	}
}
public class AnimalTest {
	public static void main(String[] args) {
		Animal animal = new Animal(3, "Å«»Ô¼Ò", true);
		System.out.println(animal.getName() + "´Â " 
						+ (animal.isLive() ? "»ì¾ÆÀÖ´Ù." : "Á×¾ú´Ù."));
		animal.setName("Æë±Ï");
		System.out.println(animal.getName() + "´Â " 
						+ (animal.isLive() ? "»ì¾ÆÀÖ´Ù." : "Á×¾ú´Ù."));
	}
}
