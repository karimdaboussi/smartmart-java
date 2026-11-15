public class Customer {
  private int customerId;
private String customerName;

public Customer(int customerId,String customerName){
this.customerId=customerId;
this.customerName=customerName;
}

public int getCustomerId(){
return customerId;
}

public String getCustomerName(){
return customerName;
}

@Override
public boolean equals(Object obj){
if(this == obj){
return true;
}
if(!(obj instanceof Customer)){
return false;
}
Customer other = (Customer) obj;
return other.customerId == this.customerId;
}

@Override
public int hashCode(){
    return Integer.hashCode(customerId);
}

@Override
public String toString(){
return "name: "+customerName + " Id: "+customerId;
}
}
