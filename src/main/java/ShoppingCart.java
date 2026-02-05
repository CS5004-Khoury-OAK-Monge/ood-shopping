import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

record Order(Product product, int quantity) { }

public class ShoppingCart {

    private User customer; // establishes a "has-a" relationship
    // TODO: container of products that are in the cart, for now just one!

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
        // FIXME!!
        return 0; // this.item.getPrice() * this.quantity;
    }

    @Override
    public String toString() {
//        String result = "";
//        for (Order p : orders) {
//            result += p + "; ";
//        }
//        return result;
//

        // code refactored to not use loop, instead we use Stream map-filter-reduce strategy

        return orders.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("; "));
    }
}
