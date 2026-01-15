import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    private Product rubberDucky;

    @BeforeEach
    public void setUp() {
        rubberDucky = new Product("Rubber Ducky", 17.99f, 1500);
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

}
