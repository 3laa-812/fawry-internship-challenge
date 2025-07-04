import java.util.*;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shippingWeight = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            // Expiry check
            if (product instanceof Expirable) {
                Expirable exp = (Expirable) product;
                if (exp.isExpired()) {
                    System.out.println("Error: Product " + product.getName() + " is expired.");
                    return;
                }
            }

            // Quantity check
            if (quantity > product.getQuantity()) {
                System.out.println("Error: Product " + product.getName() + " is out of stock.");
                return;
            }

            subtotal += product.getPrice() * quantity;

            // Shipping
            if (product instanceof Shippable) {
                Shippable ship = (Shippable) product;
                for (int i = 0; i < quantity; i++) {
                    toShip.add(ship);
                    shippingWeight += ship.getWeight();
                }
            }
        }

        double shippingFees = shippingWeight * 30; // 30 per kg
        double total = subtotal + shippingFees;

        // Balance check
        if (total > customer.getBalance()) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        // Deduct quantity
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().decreaseQuantity(entry.getValue());
        }

        // Deduct balance
        customer.deductBalance(total);

        // Print shipping
        if (!toShip.isEmpty()) {
            System.out.println("** Shipment notice **");
            Map<String, Double> shippingMap = new LinkedHashMap<>();
            for (Shippable s : toShip) {
                shippingMap.put(s.getName(), shippingMap.getOrDefault(s.getName(), 0.0) + s.getWeight());
            }
            for (Map.Entry<String, Double> entry : shippingMap.entrySet()) {
                System.out.printf("%s\t%.0fg\n", entry.getKey(), entry.getValue() * 1000);
            }
            System.out.printf("Total package weight %.1fkg\n", shippingWeight);
        }

        // Print receipt
        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%dx %s\t%.0f\n", quantity, product.getName(), product.getPrice() * quantity);
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shippingFees);
        System.out.printf("Amount\t\t%.0f\n", total);
        System.out.printf("Customer Balance\t%.0f\n", customer.getBalance());
    }
}
