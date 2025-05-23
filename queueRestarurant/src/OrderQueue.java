import java.util.*;

public class OrderQueue {
    private Queue<Order> normalQueue = new LinkedList<>();
    private PriorityQueue<Order> vipQueue = new PriorityQueue<>();
    private List<Order> archive = new ArrayList<>();

    public void addOrder(Order order) {
        if (order.isVIP()) {
            vipQueue.add(order);
        } else {
            normalQueue.add(order);
        }
    }

    public Order processNextOrder() {
        Order order;
        if (!vipQueue.isEmpty()) {
            order = vipQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            order = normalQueue.poll();
        } else {
            return null;
        }
        archive.add(order);
        return order;
    }

    public void printPendingOrders() {
        System.out.println("VIP orders: ");
        vipQueue.forEach(System.out::println);
        System.out.println("Normal orders: ");
        normalQueue.forEach(System.out::println);
    }

    public void printArchived() {
        System.out.println("Completed orders: ");
        archive.forEach(System.out::println);
    }

}
