package com.mall.service;

import com.mall.pojo.Users;
import com.mall.pojo.bo.UserBo;

import java.util.List;

/**
 * @author bryin
 * @create 2020-05-18 15:30
 */
public interface UsersService {
    List<Users> queryAll();
    void addUser(UserBo userBo);
    List<Users> queryUserByCondition(UserBo userBo);
}
