package test;

import exceptions.UserNotFoundException;
import models.User;
import org.junit.Test;
import services.UserService;

import static junit.framework.TestCase.assertEquals;

public class UserServiceTest {
    @Test
    public void registerAndFindUser() throws UserNotFoundException {
        UserService userService = new UserService();
        User user = new User("Alice", "U001");
        userService.registerUser(user);

        User foundUser = userService.findUser("U001");
        assertEquals("Alice", foundUser.getName());
    }
}
