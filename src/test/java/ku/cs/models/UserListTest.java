package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        UserList userList = new UserList();
        userList.addUser("pawat", "1234");
        userList.addUser("john", "5678");
        userList.addUser("jane", "91011");

        User user = userList.findUserByUsername("john");

        String expected = "john";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        UserList userList = new UserList();
        userList.addUser("pawat", "1234");
        userList.addUser("nunez", "9999");
        userList.addUser("messi", "1010");

        boolean actual = userList.changePassword("messi", "1010", "newpass123");

        assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        UserList userList = new UserList();
        userList.addUser("pawat", "1234");
        userList.addUser("nunez", "9999");
        userList.addUser("messi", "1010");

        User user = userList.login("messi", "1010");

        assertNotNull(user);
        assertEquals("messi", user.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        UserList userList = new UserList();
        userList.addUser("pawat", "1234");
        userList.addUser("nunez", "9999");
        userList.addUser("messi", "1010");

        User user = userList.login("nunez", "wrongpassword");

        assertNull(user);
    }
}
