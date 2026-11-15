import java.util.LinkedList;

public class CheckoutQueue {

    private LinkedList<Customer> waitingCustomers;

    public CheckoutQueue() {
        waitingCustomers = new LinkedList<>();
    }

    public boolean enqueueCustomer(Customer c) {
        if (c == null || waitingCustomers.contains(c)) {
            return false;
        }

        waitingCustomers.addLast(c);
        return true;
    }

    public Customer peekNextCustomer() {
        return waitingCustomers.peekFirst();
    }

    public Customer serveNextCustomer() {
        if (waitingCustomers.isEmpty()) {
            return null;
        }

        return waitingCustomers.removeFirst();
    }

    public void displayQueue() {
        int pos = 1;

        for (Customer customer : waitingCustomers) {
            System.out.println(
                "Position [" + pos + "] Customer: "
                + customer.getCustomerName()
            );
            pos++;
        }
    }
}