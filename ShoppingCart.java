package Eccommerce;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            items.add(product);
        }
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Product item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public boolean containsAgeRestrictedItem() {
        for (Product item : items) {
            if (item.isAgeRestricted()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
}