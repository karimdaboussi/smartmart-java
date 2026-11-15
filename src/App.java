public class App {
    public static void main(String[] args) throws Exception {
   System.out.println("=================================");
        System.out.println("     SMARTMART MANAGEMENT");
        System.out.println("=================================");

            // ==========================================
        // 1. CREATE SMARTMART SYSTEM
        // ==========================================

        SmartMartSystem mart = new SmartMartSystem();

        // ==========================================
        // 2. CREATE PRODUCTS
        // ==========================================

        Product milk = new Product(
            101, "Milk", 2.50, 20, "Dairy"
        );

        Product bread = new Product(
            102, "Bread", 1.50, 30, "Bakery"
        );

        Product coffee = new Product(
            103, "Coffee", 8.00, 10, "Drinks"
        );

        Product juice = new Product(
            104, "Juice", 3.00, 15, "Drinks"
        );
  // ==========================================
        // 3. TEST PRODUCT REGISTRATION (HASHMAP)
        // ==========================================

        System.out.println("\n=== PRODUCT REGISTRATION ===");

        System.out.println("Add Milk: "
                + mart.registerProduct(milk));

        System.out.println("Add Bread: "
                + mart.registerProduct(bread));

        System.out.println("Add Coffee: "
                + mart.registerProduct(coffee));

        System.out.println("Add Juice: "
                + mart.registerProduct(juice));

        // Duplicate product ID
        Product duplicateMilk = new Product(
            101, "Another Milk", 5.00, 10, "Dairy"
        );

        System.out.println("Add duplicate ID 101: "
                + mart.registerProduct(duplicateMilk));

        System.out.println("\n=== INITIAL INVENTORY ===");
        mart.displayInventory();

                // ==========================================
        // 4. TEST CUSTOMER REGISTRATION (HASHSET)
        // ==========================================
 System.out.println("\n=== CUSTOMER REGISTRATION ===");

        Customer ahmad = new Customer(201, "Ahmad");
        Customer sara = new Customer(202, "Sara");
        Customer omar = new Customer(203, "Omar");

        System.out.println("Register Ahmad: "
                + mart.registerCustomer(ahmad));

        System.out.println("Register Sara: "
                + mart.registerCustomer(sara));

        System.out.println("Register Omar: "
                + mart.registerCustomer(omar));

        Customer duplicateAhmad =
                new Customer(201, "Another Ahmad");

        System.out.println("Register duplicate ID 201: "
                + mart.registerCustomer(duplicateAhmad));

        System.out.println("\n=== REGISTERED CUSTOMERS ===");
        mart.displayCustomers();

        // ==========================================
        // 5. TEST CHECKOUT QUEUE (LINKEDLIST)
        // ==========================================

        System.out.println("\n=== CHECKOUT QUEUE ===");

        System.out.println("Queue Ahmad: "
                + mart.enqueueCustomer(201));

        System.out.println("Queue Sara: "
                + mart.enqueueCustomer(202));

        System.out.println("Queue Omar: "
                + mart.enqueueCustomer(203));

        // Duplicate waiting customer
        System.out.println("Queue Ahmad again: "
                + mart.enqueueCustomer(201));

        // Unregistered customer
        System.out.println("Queue unknown customer: "
                + mart.enqueueCustomer(999));

        System.out.println("\nWaiting customers:");
        mart.displayQueue();

        System.out.println("\nNext customer:");
        System.out.println(mart.peekNextCustomer());

        System.out.println("\nServing first customer:");
        System.out.println(mart.serveNextCustomer());

        System.out.println("\nQueue after serving:");
        mart.displayQueue();

        // ==========================================
        // 6. TEST SALES PROCESSING (ARRAYLIST)
        // ==========================================

        System.out.println("\n=== SALES PROCESSING ===");

        // Ahmad buys 3 Milk
        System.out.println("Sale #1 - Ahmad buys 3 Milk: "
                + mart.processSale(1, 201, 101, 3));

        // Sara buys 2 Coffee
        System.out.println("Sale #2 - Sara buys 2 Coffee: "
                + mart.processSale(2, 202, 103, 2));

        // Omar buys 5 Bread
        System.out.println("Sale #3 - Omar buys 5 Bread: "
                + mart.processSale(3, 203, 102, 5));

        // ==========================================
        // 7. TEST INVALID SALES
        // ==========================================

        System.out.println("\n=== INVALID SALES TESTS ===");

        // Product does not exist
        System.out.println("Unknown product: "
                + mart.processSale(4, 201, 999, 2));

        // Customer does not exist
        System.out.println("Unknown customer: "
                + mart.processSale(5, 999, 101, 2));

        // Insufficient stock
        System.out.println("Insufficient stock: "
                + mart.processSale(6, 201, 101, 1000));

        // Negative quantity
        System.out.println("Negative quantity: "
                + mart.processSale(7, 201, 101, -5));

        // Zero quantity
        System.out.println("Zero quantity: "
                + mart.processSale(8, 201, 101, 0));

        // Duplicate sale ID
        System.out.println("Duplicate sale ID: "
                + mart.processSale(1, 201, 101, 1));

        // ==========================================
        // 8. DISPLAY SALES HISTORY
        // ==========================================

        System.out.println("\n=== SALES HISTORY ===");
        mart.displaySalesHistory();

        // ==========================================
        // 9. CALCULATE TOTAL REVENUE
        // ==========================================

        System.out.println("\n=== TOTAL REVENUE ===");

        System.out.println("Revenue: $"
                + mart.calculateTotalRevenue());

        // Expected:
        // Milk:   3 * 2.50 = 7.50
        // Coffee: 2 * 8.00 = 16.00
        // Bread:  5 * 1.50 = 7.50
        // Total = 31.00

        // ==========================================
        // 10. TEST RESTOCKING
        // ==========================================

        System.out.println("\n=== RESTOCK INVENTORY ===");

        System.out.println("Restock Milk by 10: "
                + mart.restockProduct(101, 10));

        System.out.println("Restock invalid product: "
                + mart.restockProduct(999, 10));

        System.out.println("Restock negative quantity: "
                + mart.restockProduct(101, -5));

        // ==========================================
        // 11. DISPLAY UPDATED INVENTORY
        // ==========================================

        System.out.println("\n=== UPDATED INVENTORY ===");
        mart.displayInventory();

        // ==========================================
        // 12. PRODUCT RANKING (TREESET)
        // ==========================================

        System.out.println("\n=== PRODUCT PRICE RANKING ===");
        mart.displayProductRanking();

        // Expected order:
        // Coffee 8.00
        // Juice  3.00
        // Milk   2.50
        // Bread  1.50

        // ==========================================
        // 13. REMOVE DISCONTINUED PRODUCTS
        // ==========================================

        System.out.println("\n=== DISCONTINUED PRODUCTS ===");

        int removed = mart.removeDiscontinuedProducts();

        System.out.println("Removed products: " + removed);

        // Expected: 0
        // All products currently have positive stock.

        // ==========================================
        // 14. DISPLAY DASHBOARD
        // ==========================================

        mart.displayDashboard();

        System.out.println("\n=================================");
        System.out.println("     SMARTMART TEST FINISHED");
        System.out.println("=================================");
    }
}