package com.mall.service.impl;

import com.mall.mapper.UserMapper;
import com.mall.pojo.User;
import com.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author bryin
 * @create 2020-05-19 21:39
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {

//        userMapper.addUser(user);
    }
}
