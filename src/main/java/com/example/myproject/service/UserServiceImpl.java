package com.example.myproject.service;

import com.example.myproject.model.User;

public class UserServiceImpl implements UserService {

    @Override
    public User createUser(String username, String email) {
        // Create a new User object with the provided username and email
        User user = new User(username, email); // Call the parameterized constructor
        return user;
    }
}

