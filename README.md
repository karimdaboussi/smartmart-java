SmartMart — Java Collections Management System
SmartMart is a console-based supermarket management application built with Core Java in Visual Studio Code. It is a learning project that combines object-oriented programming (OOP) with five Java collection types in a single system.
Features
- Inventory: Register products, prevent duplicate product IDs, find products, restock, update stock after sales, and display inventory.
- Customers: Register customers and prevent duplicate customer IDs.
- Checkout queue: Add registered customers to a waiting line, view who's next, and serve customers in first-in, first-out (FIFO) order.
- Sales: Validate purchases, record completed sales, show sales history, and calculate revenue.
- Product ranking: Display products sorted by price (highest first; product ID breaks ties).
- Dashboard: Show customer count, completed sales, and total revenue.
Java Collections Used
Collection	Class	Why it's used
HashMap<Integer, Product>	ProductInventory	Retrieve products by ID
HashSet<Customer>	CustomerManagement	Prevent duplicate registered customers using equals() and hashCode()
LinkedList<Customer>	CheckoutQueue	Manage a FIFO waiting line
ArrayList<Sale>	SalesManager	Keep sales in the order they were recorded
TreeSet<Product>	ProductRanking	Sort products using a Comparator


Project Structure
This matches the Visual Studio Code Java project layout, not a Maven project:
SmartMartSystem/
├── .vscode/
│   └── settings.json
├── bin/                     # Compiled output (ignored by Git)
├── lib/                     # Optional local libraries
├── src/
│   ├── App.java             # Main entry point
│   ├── SmartMartSystem.java # Coordinates operations
│   ├── Product.java
│   ├── ProductInventory.java
│   ├── Customer.java
│   ├── CustomerManagement.java
│   ├── CheckoutQueue.java
│   ├── Sale.java
│   ├── SalesManager.java
│   └── ProductRanking.java
├── .gitignore
└── README.md
Requirements
- Java Development Kit (JDK)
- Visual Studio Code
- Extension Pack for Java
No database or Maven setup is required for the current project.
How to Run
In VS Code
1. Clone or download the repository.
2. Open the SmartMartSystem folder in VS Code.
3. Install the Java extension pack and ensure a JDK is configured.
4. Open src/App.java.
5. Click Run above main() (assuming App.java contains your main method).
From a terminal (for Java files in the default package)
From the project root:
javac -d bin src/*.java
java -cp bin App
If you later add Java package declarations, update the run command to use the fully qualified class name.
Example Workflow
1. Register products and customers.
2. Add registered customers to the checkout queue.
3. Process a purchase only if the customer and product exist and stock is sufficient.
4. Review the updated inventory and sales history.
5. Check the total revenue, product ranking, and dashboard.
Concepts Practiced
- OOP: encapsulation, composition, and separation of responsibilities
- Java generics and Collections Framework
- equals() and hashCode() for HashSet uniqueness
- Comparator for TreeSet ordering
- Iteration and safe removal
- Input validation and edge-case handling
- Git and GitHub for version control
Current Scope
SmartMart is an educational in-memory console application. Its data is not saved between runs, and it does not include a database, REST API, or graphical interface.
Future Improvements
- Unit testing with JUnit
- Persistent storage with PostgreSQL
- REST APIs with Spring Boot
- Authentication and authorization
- Web dashboard
