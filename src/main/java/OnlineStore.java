public class OnlineStore {
    public static void main(String[] args) {
//        System.out.printf("Hello %s!\n", args[0]);

        Product ducky = new Product("Yellow Rubber Ducky", 17.99f, 1500, ProductType.TOYS);
        Product spiderman = new Product("Spiderman Action Figure", 9.99f, 225, ProductType.TOYS);
        Product iPhone = new Product("iPhone 17 Pro", 899f, 100, ProductType.ELECTRONICS);
        Product ergonomicChair = new Product("Herman Miller 2000", 450.49f, 50, ProductType.FURNITURE);

        User professor = new User("Alvaro", "Monge", "a.monge@nu.edu", 18);

//        System.out.println("Hello " + ducky);
//        System.out.println("Hello " + professor);

        ShoppingCart cart = new ShoppingCart(professor);

        // Add items to the shopping cart
        cart.add(ducky, 2);
        cart.add(iPhone, 3);
        System.out.println(cart);

        // Find and print the subtotal of items in the cart

        // Find and print most expensive product in the cart

        // Find and print the cart items that are less than $25
    }
}
