import java.util.Comparator;

public class InventoryComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getUnitsInStock() < p2.getUnitsInStock())
            return -1;
        if  (p1.getUnitsInStock() == p2.getUnitsInStock())
            return 0;
        return 1;
    }

    // SEE: class slides on more compact implementation instead of using if/else
}