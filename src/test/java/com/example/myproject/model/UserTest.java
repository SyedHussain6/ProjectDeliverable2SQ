package com.example.myproject.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    // Test case to create a user with valid username and email
    @Test
    public void CreateUserTest() {
        // Create a sample user
        User user = new User("Bobby Bob", "bobby.bob@gmail.com");

        // Verify user attributes
        assertEquals("Bobby Bob", user.getUsername());
        assertEquals("bobby.bob@gmail.com", user.getEmail());
    }

    // Test case to create another user with valid username and email
    @Test
    public void CreateUserTest2() {
        // Create a sample user
        User user = new User("Johnny Deer", "johnnydeeer@gmail.com");

        // Verify user attributes
        assertEquals("Johnny Deer", user.getUsername());
        assertEquals("johnnydeeer@gmail.com", user.getEmail());
    }

    // Test case to create a user with a single-word username
    @Test
    public void CreateUserTest3() {
        // Create a sample user
        User user = new User("Deer", "deeer@gmail.com");

        // Verify user attributes
        assertEquals("Deer", user.getUsername());
        assertEquals("deeer@gmail.com", user.getEmail());
    }
}
