import java.util.TreeSet;
import java.util.Comparator;

public class ProductRanking {

    private TreeSet<Product> rankedProducts;

    // Constructor:
    
    public ProductRanking(){
    rankedProducts = new TreeSet<>(Comparator.comparingDouble(Product :: getPrice).thenComparingInt(Product :: getProductId));
    }
 

  public void refreshRanking(ProductInventory inventory) {

        rankedProducts.clear();

        for (Product p : inventory.getAllProducts()) {
            rankedProducts.add(p);
        }
    }

    // Return the most expensive product
    public Product getMostExpensiveProduct() {

        if (rankedProducts.isEmpty()) {
            return null;
        }

        return rankedProducts.first();
    }

    // Display products from highest to lowest price
    public void displayRanking() {

        if (rankedProducts.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("=== PRODUCT RANKING ===");

        int rank = 1;

        for (Product p : rankedProducts) {
            System.out.println(
                rank + ". " + p.getName()
                + " | ID: " + p.getProductId()
                + " | Price: " + p.getPrice()
            );

            rank++;
        }
    }
}