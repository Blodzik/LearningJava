public class Order implements Comparable<Order>{
    private static int counterId = 1;

    private int id;
    private String customerName;
    private boolean isVIP;
    private String details;

    public Order(String customerName, boolean isVIP, String details) {
        this.id = counterId++;
        this.customerName = customerName;
        this.isVIP = isVIP;
        this.details = details;
    }

    public int getId() { return id; };
    public String getCustomerName() { return customerName; }
    public boolean isVIP() { return isVIP; }
    public String getDetails() { return details; }

    @Override
    public String toString() {
        return "[#" + id + "] " + customerName + " - " + details + (isVIP ? " (VIP)" : "");
    }

    @Override
    public int compareTo(Order other) {
        return Boolean.compare(!this.isVIP(), !other.isVIP());
    }
}
