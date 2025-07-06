import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public InventoryManager() {
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
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
    }

    public void removeProduct(String productId) {
        Product product = findProductById(productId);
        if(product != null) {
            products.remove(product);
            System.out.println("Product removed : " + product.getName());
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

    
}
