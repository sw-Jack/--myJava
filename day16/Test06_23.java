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
      Dolphin dolphin = new Dolphin(10, "돌고래", true, true);
      System.out.println(dolphin.getName() + "는 " + dolphin.getAge() + 
         "살이고 " + (dolphin.isGender() ? "수컷이고 " : "암컷이고 ") +
         (dolphin.isSwim() ? "수영을 잘합니다" : "수영을 못합니다"));
      Swan swan = new Swan(5, "백조", false, true);
      System.out.println(swan.getName() + "는 " + swan.getAge() + 
         "살이고 " + (swan.isGender() ? "수컷이고 " : "암컷이고 ") +
         (swan.isFly() ? "하늘을 잘 납니다" : "하늘을 못 납니다"));
   }
}