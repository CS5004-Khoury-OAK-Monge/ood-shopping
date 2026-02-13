import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    ShoppingCart cart;
    User customer;
    List<Product> products;

    @BeforeEach
    public void setUp() {
        customer = new User("Mary", "Jane", "mj@marvel.com", 22);
        cart = new ShoppingCart(customer);
        products = new ArrayList<>(List.of(
                new Product("Hot Wheels car", 4.99f, 100, ProductType.TOYS, "Mattel"),
                new Product("Hot Wheels track", 15.49f, 20, ProductType.TOYS),
                new Product("Google Pixel 10", 599f, 15, ProductType.ELECTRONICS)
        ));
    }

    @Test
    public void testAddOneProduct() {
        cart.add(products.getFirst(), 5);
        List<Product> contents = cart.getItems();
        assertEquals(1, contents.size());
        // More to be tested, such as ensuring the quantity is 5 and the product is the one added
    }

    @Test
    public void testAddManyProducts() {
        products.forEach(p -> cart.add(p, 3));
        List<Product> contents = cart.getItems();
        assertEquals(3, contents.size());
    }

    @Test
    public void testDuplicateProduct() {
        cart.add(products.getFirst(), 5);
        cart.add(products.getFirst(), 2);

        List<Order> contents = cart.getOrders(quantity -> true);

        assertEquals(1, contents.size());
        assertEquals(products.getFirst(), contents.getFirst().product());
        assertEquals(2, contents.getFirst().quantity());
    }
}