import java.util.*;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("❌ Not enough stock for: " + product.getName());
            return;
        }

        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            subtotal += entry.getKey().getPrice() * entry.getValue();
        }
        return subtotal;
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> result = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            if (p instanceof Shippable) {
                for (int i = 0; i < qty; i++) {
                    result.add((Shippable) p);  // add multiple times based on quantity
                }
            }
        }
        return result;
    }
}
