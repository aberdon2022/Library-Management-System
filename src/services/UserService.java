package services;

import exceptions.UserNotFoundException;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void registerUser (User user) {
        this.users.put(user.getUserID(), user);
    }

    public User findUser (String userID) throws UserNotFoundException {
        User user = this.users.get(userID);
        if (user == null) {
            throw new UserNotFoundException("User not found " + userID);
        }
        return user;
    }
}
