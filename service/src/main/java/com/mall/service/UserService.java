package com.mall.service;

import com.mall.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author bryin
 * @create 2020-05-19 21:30
 */

public interface UserService {
    /**
     * 新增用户
     * @param user 传递的用户参数对象
     */
    void addUser(User user);
}
