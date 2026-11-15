SmartMart — Java Collections Management System
A console-based supermarket management project built with Core Java. SmartMart demonstrates object-oriented programming, Java Collections, and coordination between classes through realistic inventory, customer, checkout, sales, and reporting workflows.
Features
- Product inventory: Register products, find products by ID, restock, manage stock, and display inventory.
- Customer registration: Register customers and prevent duplicate customer IDs.
- Checkout queue: Add registered customers to a FIFO queue, see the next customer, and serve customers in arrival order.
- Sales management: Validate purchases, reduce stock, store sales history, and calculate revenue.
- Product ranking: Display products from highest to lowest price, using product ID as a tiebreaker.
- Dashboard: Display summary information, including registered customers, completed sales, and revenue.
Java Collections Used
Collection	Where it is used	Purpose
HashMap<Integer, Product>	ProductInventory	Find products quickly by ID
HashSet<Customer>	CustomerManagement	Keep customer registrations unique
LinkedList<Customer>	CheckoutQueue	First-in, first-out waiting line
ArrayList<Sale>	SalesManager	Preserve sales history in insertion order
TreeSet<Product>	ProductRanking	Keep products sorted by price


Project Structure
smartmart/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── smartmart/
│                   ├── Main.java
│                   ├── SmartMartSystem.java
│                   ├── Product.java
│                   ├── ProductInventory.java
│                   ├── Customer.java
│                   ├── CustomerManagement.java
│                   ├── CheckoutQueue.java
│                   ├── Sale.java
│                   ├── SalesManager.java
│                   └── ProductRanking.java
├── pom.xml
├── .gitignore
└── README.md
This layout is an example for a Maven project. If your project uses a different source folder, package, or main-class name, update this section to match your files.

Requirements
- Java Development Kit (JDK) compatible with your project
- Visual Studio Code with the Extension Pack for Java
- Maven, if the project uses pom.xml
How to Run
1. Clone the repository or download it as ZIP.
2. Open the SmartMart project folder in Visual Studio Code.
3. Ensure that the Java extension recognizes the project and JDK.
4. Open Main.java (or the class containing public static void main(String[] args)).
5. Click Run above the main method.
If you use Maven, you can also compile with:
mvn compile
Example Workflow
1. Register products and customers.
2. Place registered customers in the checkout queue.
3. Process valid sales, checking stock before reducing quantities.
4. Display the sales history and total revenue.
5. View products ranked by price.
6. Display the summary dashboard.
Concepts Practiced
- Java OOP: encapsulation, composition, and class responsibilities
- Generics and the Java Collections Framework
- equals() and hashCode() for custom-object uniqueness
- Comparator for custom sorting
- Iterator for safe removal during iteration
- Validation, edge cases, and method return values
- Git and GitHub version control
Project Scope
SmartMart is a learning-focused console application. It currently uses in-memory collections rather than a database. Data is not persisted between application runs.
Future Improvements
- Automated tests using JUnit
- Persistent storage using PostgreSQL
- REST API using Spring Boot
- Input validation and more detailed error handling
- A frontend dashboard