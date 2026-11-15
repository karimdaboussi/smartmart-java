public class Sale {
 private int saleId;
   private int customerId;
   private int productId;
   private int quantity;
   private double totalPrice;
   
   public Sale(int saleId,int customerId,int productId,int quantity,double totalPrice){
   this.customerId=customerId;
   this.productId=productId;
   this.quantity=quantity;
   this.saleId=saleId;
   this.totalPrice = totalPrice;
   
   }
   
   public int getSaleId(){
   return saleId;
   }
   
   public int getCustomerId(){
   return customerId;
   }
   public int getProductId(){
   return productId;
   }
   public int getQuantity(){
   return quantity;
   }
   
   public double getTotalPrice(){
   return totalPrice;
   }
   
   @Override
   public String toString(){
   return "Sale Id: "+saleId + "Customer Id: "+customerId+ "Product Id: "+productId+"quantity: "+quantity+"total price:"+totalPrice;
   }
}
