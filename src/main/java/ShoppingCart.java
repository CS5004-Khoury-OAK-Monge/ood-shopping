public class ShoppingCart {

    private User customer; // establishes a "has-a" relationship
    // TODO: container of products that are in the cart, for now just one!
    private Product item;
    private int quantity; // the number of items

    public ShoppingCart(User customer) {
        this.customer = customer;
    }

    public User getCustomer() {
        return customer;
    }

    public void add(Product item, int quantity) {
        item.decreaseInventory(quantity);
        this.item = item;
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return this.item.getPrice() * this.quantity;
    }
}
