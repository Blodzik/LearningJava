import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;
public class Order {
    private String orderID;
    private ArrayList<Product> items;
    private Date orderDate;
    private double totalPrice;

    public Order(ArrayList<Product> items) {
        this.orderID = UUID.randomUUID().toString();
        this.items = items;
        this.orderDate = new Date();
        this.totalPrice = calculateTotalPrice(items);
    }

    private double calculateTotalPrice(ArrayList<Product> items) {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public String getOrderID() {
        return orderID;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", items=" + items +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
