import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        inventoryManager.readInventoryFromFile();

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Remove Product");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter product category: ");
                    String category = scanner.nextLine();
                    System.out.println("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(name, category, price, quantity);
                    inventoryManager.addProduct(product);
                    break;
                case 2:
                    inventoryManager.listAllProducts();
                    break;
                case 3:
                    System.out.println("Enter product ID: ");
                    String productID = scanner.nextLine();
                    inventoryManager.removeProduct(productID);
                    break;
                case 4:
                    inventoryManager.listAllProducts();

                    if(inventoryManager.getProducts().isEmpty()) {
                        break;
                    }

                    System.out.println("Enter product numbers to order (comma-separated, e.g., 1,3,4): ");
                    String input = scanner.nextLine();
                    String[] parts = input.split(",");

                    ArrayList<Product> selectedItems = new ArrayList<>();
                    ArrayList<Product> allProducts = inventoryManager.getProducts();

                    for(String part : parts) {
                        try {
                            int index = Integer.parseInt(part.trim()) - 1;
                            if(index >= 0 && index < allProducts.size()) {
                                Product p = allProducts.get(index);

                                if(p.getQuantity() > 0) {
                                    selectedItems.add(new Product(p.getName(), p.getCategory(), p.getPrice(), 1));
                                    p.setQuantity(p.getQuantity() - 1);
                                } else {
                                    System.out.println("Product " + p.getName() + " is out of stock");
                                }
                            } else {
                                System.out.println("Invalid product number: " + (index + 1));
                            }
                        } catch(NumberFormatException e) {
                            System.out.println("Invalid input: " + part.trim());
                        }
                    }

                    if(!selectedItems.isEmpty()) {
                        inventoryManager.placeOrder(selectedItems);
                    } else {
                        System.out.println("No valids products selected");
                    }
                    break;
                case 5:
                    inventoryManager.viewAllOrders();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}