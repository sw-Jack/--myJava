class Animal{
   private int age;
   private String name;
   private boolean gender;
   
   public Animal(){
   
   }

   public Animal(int age, String name, boolean gender){
      this.name = name;
      this.age = age;
      this.gender = gender;
   }

   public void setAge(int age){
      this.age = age;
   }
   public int getAge(){
      return age;
   }
   public void setName(String name){
      this.name = name;
   }
   public String getName(){
      return name;
   }
   public boolean isGender(){
      return gender;
   }
   public void setGender(boolean gender){
      this.gender = gender;
   }
}
class Dolphin extends Animal{
   private boolean swim;

   public Dolphin(){
   
   }
   
   public Dolphin(int age, String name, boolean gender, boolean swim){
      super(age, name, gender);
      this.swim = swim;
   }
   
   public boolean isSwim(){
      return swim;
   }
   public void setSwim(boolean swim){
      this.swim = swim;
   }
}
class Swan extends Animal{
   private boolean fly;

   public Swan(){
   
   }
   
   public Swan(int age, String name, boolean gender, boolean fly){
      super(age, name, gender);
      this.fly = fly;
   }
   
   public boolean isFly(){
      return fly;
   }
   public void setFly(boolean fly){
      this.fly = fly;
   }
}
public class Test06_23 {
   public static void main(String[] ar){
      Dolphin dolphin = new Dolphin(10, "����", true, true);
      System.out.println(dolphin.getName() + "�� " + dolphin.getAge() + 
         "���̰� " + (dolphin.isGender() ? "�����̰� " : "�����̰� ") +
         (dolphin.isSwim() ? "������ ���մϴ�" : "������ ���մϴ�"));
      Swan swan = new Swan(5, "����", false, true);
      System.out.println(swan.getName() + "�� " + swan.getAge() + 
         "���̰� " + (swan.isGender() ? "�����̰� " : "�����̰� ") +
         (swan.isFly() ? "�ϴ��� �� ���ϴ�" : "�ϴ��� �� ���ϴ�"));
   }
}