public abstract class Test06_22 {
   private int energy;
   private String productName;
   
   public int getEnergy(){
      return energy;
   }
   public String getProductName(){
      return productName;
   }
   public void setProductName(String productName){
      this.productName = productName;
   }
   public abstract void electricMeter();//������ �Ҹ� ����
}