
import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        double totalWeight = 0;
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> weights = new HashMap<>();

        for (Shippable item : items) {
            String name = item.getName();
            counts.put(name, counts.getOrDefault(name, 0) + 1);
            weights.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : counts.keySet()) {
            System.out.println(counts.get(name) + "x " + name + "\t" + (weights.get(name) * counts.get(name) * 1000) + "g");
        }

        System.out.println("Total package weight " + (Math.round(totalWeight * 10) / 10.0) + "kg\n");
    }
}
