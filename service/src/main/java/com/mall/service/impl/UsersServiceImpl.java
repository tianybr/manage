package com.mall.service.impl;

import com.mall.mapper.UserMapper;
import com.mall.pojo.Users;
import com.mall.pojo.bo.UserBo;
import com.mall.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bryin
 * @create 2020-05-18 15:32
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Users> queryAll() {
        return userMapper.selectList(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(UserBo userBo) {
        userMapper.addUser(userBo);
    }

    @Override
    public List<Users> queryUserByCondition(UserBo userBo) {
        return userMapper.queryUserByCondition(userBo);
    }
}
