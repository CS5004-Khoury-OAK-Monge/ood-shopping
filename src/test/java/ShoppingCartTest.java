import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<Map.Entry<Product, Integer>> contents = cart.getItems();
        assertEquals(1, contents.size());
        // More to be tested, such as ensuring the quantity is 5 and the product is the one added
    }

    @Test
    public void testAddManyProducts() {
        products.forEach(p -> cart.add(p, 3));
        List<Map.Entry<Product, Integer>> contents = cart.getItems();
        assertEquals(products.size(), contents.size());
        assertEquals(products.size() * 3,
                contents.stream()
                        .map(Map.Entry::getValue)
                        .reduce(0,Integer::sum));
    }

    @Test
    public void testDuplicateProduct() {
        Product p = products.getFirst();
        int initialInventory = p.getUnitsInStock();
        cart.add(p, 5);
        cart.add(p, 2);

        List<Map.Entry<Product,Integer>> contents = cart.getItems();

        assertEquals(1, contents.size());
        assertEquals(p, contents.getFirst().getKey());
        assertEquals(7, contents.getFirst().getValue());
        assertEquals(initialInventory - 7, p.getUnitsInStock());
    }
}