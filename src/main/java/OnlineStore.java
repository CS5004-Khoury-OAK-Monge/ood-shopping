public class OnlineStore {
    public static void main(String[] args) {
        System.out.printf("Hello %s!\n", args[0]);

        Product ducky = new Product("Yellow Rubber Ducky", 17.99f, 1500);
        User professor = new User("Alvaro", "Monge", "a.monge@nu.edu", 18);

        System.out.println("Hello " + ducky);
        System.out.println("Hello " + professor);
    }
}
