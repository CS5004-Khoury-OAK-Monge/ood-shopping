import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

record Order(Product product, int quantity) {
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other instanceof Order) {
            return this.product.equals(((Order) other).product);
        }
            return false;
    }

    @Override
    public int hashCode() {
        return this.product.hashCode();
    }}

public class ShoppingCart {

    private User customer; // establishes a "has-a" relationship
    private Set<Order> orders;

    public ShoppingCart(User customer) {
        this.customer = customer;
        this.orders = new HashSet<>();  // alternatively:  TreeSet<>()
    }

    public User getCustomer() {
        return customer;
    }

    public void add(Product item, int quantity) {
        if ( quantity <= 0 || quantity > item.getUnitsInStock() )
            throw new IllegalArgumentException("Invalid quantity value");

        // FIXME: Problem: what if a product is added more than once?

        Order productOrder = new Order(item, quantity);
        if (this.orders.contains(productOrder)) { // if already in cart
            // it's not possible to retrieve the Order that is in the set!
            // thus, we don't know the quantity being ordered, so we cannot
            // implement the cumulative effect of adding the same product twice
            // Instead, need to replace the order to have this new quantity
            this.orders.remove(productOrder);

            // ERROR: It's not possible to increase the inventory by the amount
            // of the order that was removed, because we can't recover what that
            // order was since a set doesn't have operations to retrieve such an object!
        }
        this.orders.add(productOrder);
        item.decreaseInventory(quantity);

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

    public List<Product> getItems() {
        return getItems(p -> true);
    }

    public List<Order> getOrders(Predicate<Integer> quantityPredicate) {
        return this.orders.stream()
                .filter(o -> quantityPredicate.test(o.quantity()))
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
