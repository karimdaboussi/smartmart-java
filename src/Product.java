public class Product {
 private int productId;
    private String name;
    private double price;
    private int quantity;
    private String category;
    
    
    public Product(int productId,String name,double price,int quantity,String category){
    this.category=category;
    this.name=name;
    this.price=price;
    this.productId=productId;
    this.quantity=quantity;
    }
    
    public int getProductId(){
    return productId;
    }
        public String getName(){
    return name;
    }
            public double getPrice(){
    return price;
    }
                public int getQuantity(){
    return quantity;
    }
                    public String getCategory(){
    return category;
    }
                    
                    
     public boolean setQuantity(int qty){
     if(qty<0){
     return false;
     }
     quantity = qty;
     return true;
     }
     @Override
     public String toString(){
     return "id: "+productId+" name: "+name+" price: "+price+" quantity "+quantity+" category: "+category;
     }
}
