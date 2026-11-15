import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ProductInventory {
  private HashMap<Integer, Product> products;

    public ProductInventory() {
        products = new HashMap<>(); // Fixed diamond operator
    }

    public boolean addProduct(Product p) {
        if (products.containsKey(p.getProductId())) {
            return false;
        }
        products.put(p.getProductId(), p);
        return true;
    }

    // Changed return type from boolean to Product
    public Product findProduct(int id) {
        if (products.containsKey(id)) {
            return products.get(id);
        }
        return null; // Return null if not found
    }

    public boolean restockProduct(int id, int qty) {
        if (qty < 0 || !products.containsKey(id)) {
            return false;
        }
        int currentStock = products.get(id).getQuantity(); // Declared variable type
        products.get(id).setQuantity(currentStock + qty);  // Added qty to existing stock
        return true;
    }

    public void displayInventory() {
        // Loop over products.values() instead of products
        for (Product p : products.values()) {
            System.out.println(p);
        }
        
    }

    public boolean sellProduct(int id, int qty) {
        Product product = products.get(id);
        if (product == null || qty <= 0 || product.getQuantity() < qty) {
            return false;
        }
        return product.setQuantity(product.getQuantity() - qty);
    }

    public int removeDiscontinuedProducts() {
        int previousSize = products.size();
        products.values().removeIf(product -> product.getQuantity() == 0);
        return previousSize - products.size();
    }
    
public Collection<Product> getAllProducts() {
    return Collections.unmodifiableCollection(
        products.values()
    );
}
}
