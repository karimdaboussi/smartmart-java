import java.util.HashSet;
import java.util.Iterator;

public class CustomerManagement {
 private HashSet<Customer>customers;
int count =0;
public CustomerManagement(){
customers= new HashSet<Customer>();
}


public boolean registerCustomer(Customer c){
if(customers.contains(c)){
return false;
}
customers.add(c);
count++;
return true;

}

public Customer findCustomer(int id){
    for (Customer customer : customers) {
       if( customer.getCustomerId()== id){
         return customer;
           
       }}
    return null;
}

public boolean removeCustomer(int id){

Iterator<Customer>iterator= customers.iterator();

while(iterator.hasNext()){
Customer c = iterator.next();
if(c.getCustomerId() == id){
customers.remove(c);
return true;
}
}
return false;
}

public void displayCustomer(){
    for (Customer customer : customers) {
        System.out.println(customer);
    }
}

public int countCustomers(){
return count;
}

}
