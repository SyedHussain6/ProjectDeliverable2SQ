package com.example.myproject.service;

import com.example.myproject.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    // Test case to create a user with valid username and email
    @Test
    public void CreateUserTest() {
        UserService userService = new UserServiceImpl();
        User user = userService.createUser("Billy Bob", "bb@example.com");
        assertEquals("Billy Bob", user.getUsername());
        assertEquals("bb@example.com", user.getEmail());
    }

    // Test case to create a user with another valid username and email
    @Test
    public void CreateUserTest2() {
        UserService userService = new UserServiceImpl();
        User user = userService.createUser("abd def", "abcdef@example.com");
        assertEquals("abd def", user.getUsername());
        assertEquals("abcdef@example.com", user.getEmail());
    }

    // Test case to create a user with special characters in username
    @Test
    public void CreateUserTest3() {
        UserService userService = new UserServiceImpl();
        User user = userService.createUser("--", "---@example.com");
        assertEquals("--", user.getUsername());
        assertEquals("---@example.com", user.getEmail());
    }
}
