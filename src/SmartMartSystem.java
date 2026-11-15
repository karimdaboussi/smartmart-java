public class SmartMartSystem {

    private ProductInventory inventory;
    private CustomerManagement customerManager;
    private CheckoutQueue checkoutQueue;
    private SalesManager salesManager;
    private ProductRanking productRanking;

    // Constructor: Initialize all managers
    public SmartMartSystem() {
        inventory = new ProductInventory();
        customerManager = new CustomerManagement();
        checkoutQueue = new CheckoutQueue();
        salesManager = new SalesManager();
        productRanking = new ProductRanking();
    }

    // Register a new product in inventory
    public boolean registerProduct(Product p) {
        return inventory.addProduct(p);
    }

    // Register a new customer
    public boolean registerCustomer(Customer c) {
        return customerManager.registerCustomer(c);
    }

    // Add a registered customer to the checkout queue
    public boolean enqueueCustomer(int customerId) {

        Customer customer = customerManager.findCustomer(customerId);

        if (customer == null) {
            return false;
        }

        return checkoutQueue.enqueueCustomer(customer);
    }

    // View the next waiting customer without removing them
    public Customer peekNextCustomer() {
        return checkoutQueue.peekNextCustomer();
    }

    // Serve and remove the first waiting customer
    public Customer serveNextCustomer() {
        return checkoutQueue.serveNextCustomer();
    }

    // Process a purchase and record its transaction
    public boolean processSale(int saleId, int customerId,
                               int productId, int qty) {

        // Step 1: Validate the requested quantity
        if (qty <= 0) {
            return false;
        }

        // Step 2: Make sure the customer is registered
        Customer customer = customerManager.findCustomer(customerId);

        if (customer == null) {
            return false;
        }

        // Step 3: Find the product
        Product product = inventory.findProduct(productId);

        if (product == null) {
            return false;
        }

        // Step 4: Make sure enough stock is available
        if (product.getQuantity() < qty) {
            return false;
        }

        // Step 5: Reject duplicate sale IDs
        if (salesManager.findSale(saleId) != null) {
            return false;
        }

        if (saleId <= 0) {
            return false;
        }

        // Step 6: Calculate total price
        double totalPrice = product.getPrice() * qty;

        // Step 7: Create the Sale object
        Sale sale = new Sale(
            saleId,
            customerId,
            productId,
            qty,
            totalPrice
        );

        // Step 8: Reduce stock
        if (!inventory.sellProduct(productId, qty)) {
            return false;
        }

        // Step 9: Record the completed sale
        if (!salesManager.recordSale(sale)) {

            // Restore stock if recording unexpectedly fails
            inventory.restockProduct(productId, qty);
            return false;
        }

        return true;
    }

    // Restock an existing product
    public boolean restockProduct(int productId, int qty) {
        return inventory.restockProduct(productId, qty);
    }

    // Remove products with zero stock
    public int removeDiscontinuedProducts() {
        return inventory.removeDiscontinuedProducts();
    }

    // Display current inventory
    public void displayInventory() {
        inventory.displayInventory();
    }

    // Display registered customers
    public void displayCustomers() {
        customerManager.displayCustomer();
    }

    // Display waiting customers
    public void displayQueue() {
        checkoutQueue.displayQueue();
    }

    // Display all completed sales
    public void displaySalesHistory() {
        salesManager.displaySalesHistory();
    }

    // Return revenue from completed sales
    public double calculateTotalRevenue() {
        return salesManager.calculateTotalRevenue();
    }

    // Refresh the ranking and display sorted products
    public void displayProductRanking() {

        productRanking.refreshRanking(inventory);
        productRanking.displayRanking();
    }

    // Display basic supermarket statistics
    public void displayDashboard() {

        System.out.println("\n=== SMARTMART DASHBOARD ===");

        System.out.println(
            "Registered Customers: "
            + customerManager.countCustomers()
        );

        System.out.println(
            "Completed Sales: "
            + salesManager.countSales()
        );

        System.out.println(
            "Total Revenue: "
            + salesManager.calculateTotalRevenue()
        );

        System.out.println("===========================\n");
    }
}
