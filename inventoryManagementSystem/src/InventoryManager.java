import java.io.*;
import java.util.ArrayList;


public class InventoryManager {
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public InventoryManager() {
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    //PRODUCT METHODS

    private Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added : " + product.getName());
        saveInventoryToFile();
    }

    public void removeProduct(String productId) {
        Product product = findProductById(productId);
        if(product != null) {
            products.remove(product);
            System.out.println("Product removed : " + product.getName());
            saveInventoryToFile();
        } else {
            System.out.println("Product not found");
        }
    }

    public void listAllProducts() {
        if(products.size() == 0) {
            System.out.println("No products in inventory");
        } else {
            System.out.println("\n--- Product List ---");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void listByCategory(String category) {
        System.out.println("\n--- Products in Category: " + category + " ---");
        for (Product product : products) {
            if(product.getCategory().equalsIgnoreCase(category)) {
                System.out.println(product);
            }
        }
    }


    //ORDER METHODS

    public void placeOrder(ArrayList<Product> selectedItems) {
        if(selectedItems.isEmpty()) {
            System.out.println("No items selected for order");
            return;
        }

        double total = 0.0;
        for(Product product : selectedItems) {
            total += product.getPrice();
            //reduce stock quantity
            Product selectedProduct = findProductById(product.getId());
            if(selectedProduct != null) {
                selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);
            }
        }

        Order order = new Order(selectedItems);
        orders.add(order);
        System.out.println("Order placed");
        saveInventoryToFile();
    }

    public void viewAllOrders() {
        if(orders.isEmpty()) {
            System.out.println("No orders placed yet");
            return;
        }
        for(Order order : orders) {
            System.out.println(order);
        }
    }


    // I/O file

    public void saveInventoryToFile() {
        try (PrintWriter writer = new PrintWriter("products.txt")) {
            for (Product p : products) {
                writer.println(p.getId() + ";" + p.getName() + ";" + p.getCategory() + ";" + p.getPrice() + ";" + p.getQuantity());
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void readInventoryFromFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if(parts.length == 5) {
                    Product p = new Product(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]));
                    p.setId(parts[0]);
                    products.add(p);
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("No saved inventory file found. Starting fresh");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }
}
