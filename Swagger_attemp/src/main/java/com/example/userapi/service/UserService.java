package com.example.userapi.service;

import com.example.userapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    // Mock data for testing
    public UserService() {
        users.add(new User("john", "John Doe"));
        users.add(new User("jane", "Jane Smith"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public Optional<User> findByNick(String nick) {
        return users.stream()
                .filter(user -> user.getNick().equals(nick))
                .findFirst();
    }

    public User save(User user) {
        Optional<User> existingUser = findByNick(user.getNick());
        if (existingUser.isPresent()) {
            // Update existing user
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            return updatedUser;
        } else {
            // Add new user
            users.add(user);
            return user;
        }
    }

    public boolean deleteByNick(String nick) {
        return users.removeIf(user -> user.getNick().equals(nick));
    }
}