package Eccommerce;

public class Product {
    private String name;
    private double price;
    private boolean isAgeRestricted; // +18 yaş sınırı gerektiren ürünler için (Örn: Bıçak, Çakmak vb.)

    public Product(String name, double price, boolean isAgeRestricted) {
        this.name = name;
        this.price = price;
        this.isAgeRestricted = isAgeRestricted;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAgeRestricted() {
        return isAgeRestricted;
    }
    
    public String getName() {
        return name;
    }
}