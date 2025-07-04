import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese", 100, 5, LocalDate.of(2025, 8, 1), 0.2);
        Product biscuits = new Biscuits("Biscuits", 150, 3, LocalDate.of(2025, 8, 1), 0.7);
        Product card = new MobileScratchCard("Card", 50, 10);

        Customer customer = new Customer("Alaa", 1000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(card, 1);

        CheckoutService.checkout(customer, cart);
    }
}
