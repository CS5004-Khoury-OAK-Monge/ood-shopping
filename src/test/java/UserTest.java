
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test class for the User class
 */
public class UserTest {

    private User grace;
    private User steve;

    @BeforeEach
    public void setUp() {
        this.grace = new User("Grace", "Hopper", "grace@navy.us", 85);
        this.steve = new User("Steve", "Jobs", "steve@apple.com", 56);
    }

    @Test
    public void testEmail() {
        assertEquals("grace@navy.us", this.grace.getEmail());
        assertEquals("steve@apple.com", this.steve.getEmail());
    }

    @Test
    public void testAge() {
        assertEquals(85, this.grace.getAge());
        assertEquals(56, this.steve.getAge());
    }

    @Test
    public void testFullName() {
        assertEquals("Grace Hopper", this.grace.getName());
        assertEquals("Steve Jobs", this.steve.getName());
    }
}