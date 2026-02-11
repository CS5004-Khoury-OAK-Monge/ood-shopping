import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product rubberDucky;
    private Product rubberSkirt;

    @BeforeEach
    public void setUp() {
        rubberDucky = new Product("Rubber Ducky", 17.99f, 1500, ProductType.TOYS);
        rubberSkirt = new Product("Rubber Skirt", 3.49f, 10, ProductType.TOYS, "Acme");
    }

    @Test
    public void testDecreaseInventory() {
        int amountToDecrease = 5;
        int expectedInventory = 1500 - 5;
        rubberDucky.decreaseInventory(amountToDecrease);
        assertEquals(expectedInventory, rubberDucky.getUnitsInStock());


        int amountTooLarge = 1600;
        rubberDucky.decreaseInventory(amountTooLarge);
        assertEquals(expectedInventory, rubberDucky.getUnitsInStock());

    }

    @Test
    public void testDecreaseInventoryByNegative() {
        int amountToDecrease = -5;
        rubberDucky.decreaseInventory(amountToDecrease);
        assertEquals(1500, rubberDucky.getUnitsInStock());
    }

    @Test
    public void testDecreaseInventoryToZero() {

    }

    @Test
    public void testDecreaseInventoryByTooLargeAmount() {

    }

    @Test
    public void testToString() {
        String expected = "Toys: Rubber Ducky, 17.99";
        assertEquals(expected, rubberDucky.toString());
    }

    @Test
    public void testToStringWithManufacturer() {
        String expected = "Toys: Rubber Skirt, 3.49, Acme";
        assertEquals(expected, rubberSkirt.toString());
    }

    @Test
    public void testEquals() {
        assertFalse(rubberSkirt.equals(rubberDucky));

        Product woodenDucky = new Product("Wooden Ducky", 17.99f, 1500, ProductType.TOYS);
        assertFalse(woodenDucky.equals(rubberDucky));

        Product identicalRubberDucky =
                new Product("Rubber Ducky", 17.99f, 1500, ProductType.TOYS);
        assertTrue(rubberDucky.equals(identicalRubberDucky));
    }
}
