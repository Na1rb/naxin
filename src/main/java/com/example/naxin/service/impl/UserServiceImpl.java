package com.example.naxin.service.impl;

import com.example.naxin.entity.User;
import com.example.naxin.mapper.UserMapper;
import com.example.naxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}