package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }
    @Test
    public void testIsUsername() {
        User user = new User("user01", "plain-p@ssw0rd");
        assertTrue(user.isUsername("user01"));
        assertFalse(user.isUsername("user02"));
    }

    @Test
    public void testSetPassword() {
        User user = new User("user01", "plain-p@ssw0rd");
        user.setPassword("newPassword123");
        assertTrue(user.validatePassword("newPassword123"));
        assertFalse(user.validatePassword("plain-p@ssw0rd"));
    }
}