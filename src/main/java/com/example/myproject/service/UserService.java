package com.example.myproject.service;

import com.example.myproject.model.User;

public interface UserService {
    User createUser(String username, String email);
}
