
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

public class Product {
    // attributes at the top
    private String name;
    private float price;
    private int unitsInStock;
    private String manufacturer;
    // after attributes: constructors

    public Product(String name, float price, int unitsInStock, String manufacturer) {
        // TODO: What if numbers are not positive?
        this.name = name;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.manufacturer = manufacturer;
    }

    public Product(String name, float price, int unitsInStock) {
        this.name = name;
        this.price = price;
        this.unitsInStock = unitsInStock;
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

    public void setPrice(float price) {
        // TODO: need to resolve the problem where price is not positive
        if (price > 0 && price <= 100) {
            this.price = price;
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
            return this.name + ", " + this.price;
        } else {
            return this.name + ", " + this.price + ", " + this.manufacturer;
        }
    }

    /**
     *
     * @param otherProduct
     * @return
     */
    public boolean equals(Product otherProduct) {
        return (this.name.equals(otherProduct.name)
                && this.price == otherProduct.price
                && this.unitsInStock == otherProduct.unitsInStock
                &&
                (this.manufacturer == null ||
                        this.manufacturer.equals(otherProduct.manufacturer))
        );
    }
}

