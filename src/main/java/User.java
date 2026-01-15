/**
 * Represents a user of the online shopping system.
 */
public class User {
    /**
     * This is the first name field.
     * Javadoc is for public resources. This is an example of attempting to
     * use it on a private fields. No Javadoc is generated for this as it's private!
     */
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    /**
     * Creates a User object with a value for each of its fields.
     * @param firstName first name of user
     * @param lastName last name of user
     * @param email the email of user so they can login
     * @param age the age of customer, must be 18 and over
     */
    public User(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    /**
     * Retrieves the full name of the user.
     */
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public boolean verifyEmail(String email) {
        return this.email.equals(email);
    }

}