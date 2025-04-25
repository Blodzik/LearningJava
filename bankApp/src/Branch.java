import java.util.ArrayList;
public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer findCustomer(String name) {
        for(Customer customer : customers) {
            if(customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        //System.out.println("Customer not found");
        return null;
    }

    public boolean newCustomer(String name, double initialTransaction) {
        if(findCustomer(name) == null) {
            Customer customer = new Customer(name, initialTransaction);
            customers.add(customer);
            System.out.println("New customer added: " + customer);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String name, double transaction) {
        Customer customer = findCustomer(name);
        if(customer != null) {
            customer.addTransaction(transaction);
            System.out.println("Customer added: " + transaction);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
