import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShoppingCart {

    private final User customer; // establishes a "has-a" relationship
    private final Map<Product, Integer> orders;

    public ShoppingCart(User customer) {
        this.customer = customer;
        this.orders = new HashMap<>();
    }

    public User getCustomer() {
        return customer;
    }

    public void add(Product item, int quantity) {
        if ( quantity <= 0 || quantity > item.getUnitsInStock() )
            throw new IllegalArgumentException("Invalid quantity value");

        item.decreaseInventory(quantity);
        this.orders.merge(item, quantity, Integer::sum);
    }

    public float getSubtotal() {
        // FIXME: practice using Stream()
        return 0;
    }

    /**
     * Finds items in the shopping cart that satisfy the predicate on the price of products
     * @param pricePredicate the test on price that must be satisfied by item in the cart to be retrieved
     * @return the items satisfying the predicate on price
     */
    public List<Map.Entry<Product, Integer>> getItems(Predicate<Float> pricePredicate) {
        return this.orders.entrySet().stream()
                .filter(entry -> pricePredicate.test(entry.getKey().getPrice()))
                .collect(Collectors.toList());
    }

    public List<Map.Entry<Product, Integer>> getItems() {
        return this.getItems(quantity -> true);
    }


    @Override
    public String toString() {
        // code refactored to not use loop, instead we use Stream map-filter-reduce strategy

        return orders.entrySet().stream()
                .map(e -> String.format("%s, quantity=%d", e.getKey(), e.getValue()))
                .collect(Collectors.joining("; "));
    }
}
