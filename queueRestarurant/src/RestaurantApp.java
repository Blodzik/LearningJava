import java.util.Scanner;

public class RestaurantApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderQueue orderQueue = new OrderQueue();

        while(true) {
            System.out.println("\n1. Add Order");
            System.out.println("2. Process Order");
            System.out.println("3. Show Pending Orders");
            System.out.println("4. Show Completed Orders");
            System.out.println("0. Exit");

            System.out.println("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Order Details: ");
                    String orderDetails = scanner.nextLine();
                    System.out.println("Is VIP(true/false): ");
                    boolean isVIP = scanner.nextBoolean();
                    scanner.nextLine();

                    orderQueue.addOrder(new Order(name, isVIP, orderDetails));
                    System.out.println("Order added successfully.");
                }
                case 2 -> {
                    Order processed = orderQueue.processNextOrder();
                    System.out.println(processed != null ? "Processed: " + processed : "No orders to process");
                }
                case 3 -> {
                    orderQueue.printPendingOrders();
                }
                case 4 -> {
                    orderQueue.printArchived();
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }

        }
    }
}
