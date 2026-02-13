import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShoppingCart {

    private User customer; // establishes a "has-a" relationship
    private Map<Product, Integer> orders;

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
        this.orders.put(item, quantity);
    }

    public float getSubtotal() {
        // FIXME using Stream()
        return 0; // this.item.getPrice() * this.quantity;
    }

    /**
     * Finds items in the shopping cart that satisfy the predicate on the price of products
     * @param pricePredicate the test on price that must be satisfied by item in the cart to be retrieved
     * @return the items satisfying the predicate on price
     */
    public List<Product> getItems(Predicate<Float> pricePredicate) {
        return this.orders.keySet().stream()
                .filter(product -> pricePredicate.test(product.getPrice()))
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        // code refactored to not use loop, instead we use Stream map-filter-reduce strategy

        return orders.entrySet().stream()
                .map(e -> String.format("%s, quantity=%d", e.getKey(), e.getValue()))
                .collect(Collectors.joining("; "));
    }
}
