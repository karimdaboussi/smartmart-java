import java.util.ArrayList;

public class SalesManager {
 private ArrayList<Sale> sales;
     int count =0;
     public SalesManager(){
     sales = new ArrayList<>();
     }
     
     public boolean recordSale(Sale sale){
         if(sale == null){
         return false;
         }
     sales.add(sale);
     count++;
     return true;
     }
     
     public Sale findSale(int saleId){
         for (Sale sale : sales) {
             if(sale.getSaleId() == saleId){
             return sale;
             }
         }
         return null;
     }
     
     public double calculateTotalRevenue(){
     double totalRevenue = 0;
         for (Sale sale : sales) {
             totalRevenue += sale.getTotalPrice();
         }
         return totalRevenue;
     }
     
     public void displaySalesHistory(){
         for (Sale sale : sales) {
             System.out.println(sale);
         }
     }

     public int countSales(){
         return sales.size();
     }
}
