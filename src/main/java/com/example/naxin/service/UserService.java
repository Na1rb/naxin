package com.example.naxin.service;

import com.example.naxin.entity.User;

public interface UserService {
    User getUserByUsername(String username);
}