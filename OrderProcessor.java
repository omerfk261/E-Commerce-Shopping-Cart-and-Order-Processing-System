package Eccommerce;

public class OrderProcessor {
    private static final double FREE_SHIPPING_THRESHOLD = 500.0;
    private static final double DISCOUNT_THRESHOLD = 1000.0;
    private static final double SHIPPING_FEE = 50.0;
    private static final double DISCOUNT_RATE = 0.10; // %10 İndirim

    public double checkout(ShoppingCart cart, User user) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Sepet boş, sipariş verilemez.");
        }

        // 1. Yaş Sınırı Kontrolü (Branching / Koşul Testi için)
        if (cart.containsAgeRestrictedItem() && user.getAge() < 18) {
            throw new IllegalStateException("Sepette yaş sınırı olan ürün var. Kullanıcı 18 yaşından küçük olamaz.");
        }

        double total = cart.calculateSubtotal();

        // 2. İndirim Mantığı (Sınır Değer Analizi - Boundary Value Testi için)
        if (total >= DISCOUNT_THRESHOLD) {
            total = total - (total * DISCOUNT_RATE);
        }

        // 3. Kargo Ücreti Mantığı (Sınır Değer Analizi için)
        if (total < FREE_SHIPPING_THRESHOLD) {
            total += SHIPPING_FEE;
        }

        return total;
    }
}