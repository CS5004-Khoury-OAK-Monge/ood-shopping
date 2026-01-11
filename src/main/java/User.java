public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public User(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

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