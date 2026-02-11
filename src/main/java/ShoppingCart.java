import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

record Order(Product product, int quantity) { }

public class ShoppingCart {

    private User customer; // establishes a "has-a" relationship
    private List<Order> orders;

    public ShoppingCart(User customer) {
        this.customer = customer;
        this.orders = new ArrayList<>(5);
    }

    public User getCustomer() {
        return customer;
    }

    public void add(Product item, int quantity) {
        if ( quantity <= 0 || quantity > item.getUnitsInStock() )
            throw new IllegalArgumentException("Invalid quantity value");

        item.decreaseInventory(quantity);
        this.orders.add(new Order(item, quantity));
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
        return this.orders.stream()
                .map(Order::product)
                .filter(p -> pricePredicate.test(p.getPrice()))
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        // code refactored to not use loop and practice using
        // Stream map-filter-reduce strategy

        return orders.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("; "));
    }
}
