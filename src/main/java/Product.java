import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

// this is a single-line comment
/* this
is a multi-line comment
 */

/* Naming in Java
* variable and method names: useCamelCase starting with lowercase letter
* constructor name is the name of the class
* class names: UseCamelCase ... starting with uppercase letter
* constants: ALL_UPPERCASE ... using _ to separate words
 */

public class Product implements Comparable<Product> {
    // attributes at the top
    private final String name;
    private float price;
    private int unitsInStock;
    private final String manufacturer;

    private final ProductType type;

    // after attributes: constructors

    public Product(String name, float price, int unitsInStock, ProductType type, String manufacturer) {
        // TODO: What if numbers are not positive?
        this.name = name;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.type = type;
        this.manufacturer = manufacturer;
    }

    public Product(String name, float price, int unitsInStock, ProductType type) {
        this(name, price, unitsInStock, type, null);
    }

    // after constructors: methods
    // Template for a method:
    //  public returnType methodName(paramete1Type parameter1name, etc) { body }
    // method naming convention:
    //     getters:  getFieldName()
    //     setters:  setFieldName(value)

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public float getPrice() {
        return price;
    }

    /**
     * Updates the price of the product to a new price
     * @param price the new value for the product price
     * @throws IllegalArgumentException when the value for price is negative, 0, or larger than 100
     */
    public void setPrice(float price) throws IllegalArgumentException {
        // TODO: need to resolve the problem where price is not positive
        if (price > 0 && price <= 100) {
            this.price = price;
        } else { // ... communicate to whoever invoked the method that they did so incorrectly
            throw new IllegalArgumentException("The value of price must be more than 0 and less than 100");
        }
    }

    public void decreaseInventory(int quantity) {
        if (quantity > 0 &&  quantity <= unitsInStock) {
            this.unitsInStock -= quantity;
        }
        // TODO: what if there's not enough in stock?
    }

    /**
     * Returns a String representation of Product that includes
     * the name, price, and manufacturer. For example, the String
     * "Rubber Ducky, 15.99, Adidas".
     * @return a representation of the Product including name, price, and manufacturer
     */
    public String toString() {
        if (this.manufacturer == null) {
            return this.type + ": " + this.name + ", " + this.price + ", qoh=" + this.getUnitsInStock();
        } else {
            return this.type + ": " + this.name + ", " + this.price + ", qoh=" + this.getUnitsInStock() + ", " + this.manufacturer;
        }
    }

    /**
     * Tests for equality based on four of the Product fields; it excludes ProductType
     * @param other the Product to compare this to
     * @return true if they're equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {

        return EqualsBuilder.reflectionEquals(this, other);
//        if (this == other) return true; // Reference equality check
//        if (!(other instanceof Product otherProduct)) return false;
//        return (this.name.equals(otherProduct.name)
//                && Float.compare(this.price, otherProduct.price) == 0
//                && this.unitsInStock == otherProduct.unitsInStock
//                &&
//                (this.manufacturer == null ||
//                        this.manufacturer.equals(otherProduct.manufacturer))
//        );

        // Alternatively, use EqualsBuilder
        // See: https://www.codeproject.com/articles/Apache-Commons-EqualsBuilder-and-HashCodeBuilder#comments-section
        // return EqualsBuilder.reflectionEquals(this, other);
    }


    /**
     * Returns the hash code value for this Product
     * @return the hash code value for this Product
     */
    @Override
    public int hashCode() {
        // use only the name, type and manufacturer as other fields may change in value!
        // Necessary to guarantee hash code will remain the same when calculated after changes
        // to price and unitsInStock
        return HashCodeBuilder.reflectionHashCode(this, new String[] {"price", "unitsInStock"});
    }


    /**
     * Compares to other product by their name
     * @param other the object to be compared.
     * @return negative, 0, or positive integer depending on whether this is <, =, or > other
     */
    @Override
    public int compareTo(Product other) {
        return other.name.compareTo(this.name);
    }
}

