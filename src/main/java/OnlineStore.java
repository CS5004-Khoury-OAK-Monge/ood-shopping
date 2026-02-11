import java.util.Collections;
import java.util.List;

public class OnlineStore {
    public static void main(String[] args) {

        Product ducky = new Product("Yellow Rubber Ducky", 17.99f, 1500, ProductType.TOYS);
        Product spiderman = new Product("Spiderman Action Figure", 9.99f, 225, ProductType.TOYS);
        Product iPhone = new Product("iPhone 17 Pro", 899f, 100, ProductType.ELECTRONICS);
        Product ergonomicChair = new Product("Herman Miller 2000", 450.49f, 50, ProductType.FURNITURE);

        User professor = new User("Alvaro", "Monge", "a.monge@nu.edu", 18);

        ShoppingCart cart = new ShoppingCart(professor);

        // Add items to the shopping cart
        cart.add(ducky, 2);
        cart.add(iPhone, 3);
        cart.add(spiderman, 1);
        System.out.println(cart);

        // TODO: practice using Stream
        // Find and print the subtotal of items in the cart

        // TODO: practice using Stream
        // Find and print most expensive product in the cart

        // Find and print the cart items that are less than $25
        final float maxPrice = 25f;
        List<Product> cheaperItems = cart.getItems(price -> price < maxPrice);
        System.out.printf("Items less than $%.2f in cart: %s\n", maxPrice, cheaperItems);

        cheaperItems.sort(new InventoryComparator());
        System.out.printf("Sorted by amount in stock: %s\n", cheaperItems);

        // Demo the natural ordering defined by Comparable implementation
        Collections.sort(cheaperItems);
        System.out.printf("Sorted by name: %s\n", cheaperItems);

        // Demo a different ordering defined by a Comparator (using lambda expression)
        cheaperItems.sort( (a, b) -> Float.compare(a.getPrice(), b.getPrice()));
        System.out.printf("Sorted by price: %s\n", cheaperItems);


    }
}
