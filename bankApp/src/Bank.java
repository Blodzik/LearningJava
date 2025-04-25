import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public Branch findBranch(String name) {
        for(Branch b : branches) {
            if(b.getName().equalsIgnoreCase(name)) {
                return b;
            }
        }
        return null;
    }

    public boolean addBranch(String name) {
        if(findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branch.newCustomer(customerName, initialTransaction);
            System.out.println("New customer " + customerName + " added to the branch " + branchName);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            if(branch.findCustomer(customerName) != null) {
                Customer customer = branch.findCustomer(customerName);
                customer.addTransaction(initialTransaction);
                System.out.println("Customer added: " + initialTransaction);
                return true;
            }
        }
        return false;
    }

    public boolean listCustomers(String name, boolean printTransactions) {
        Branch b = findBranch(name);
        if(b != null) {
            System.out.println("Customer details for branch: " + name);
            for(Customer c : b.getCustomers()) {
                System.out.println("Customer: " + c.getName());
                if (printTransactions) {
                    System.out.println("Transactions");
                    for (int i = 0; i < c.getTransactions().size(); i++) {
                        System.out.println("[" + (i + 1) + "] Amount " + c.getTransactions().get(i));
                    }
                }
                return true;
            }
        }

        return false;
    }
}
