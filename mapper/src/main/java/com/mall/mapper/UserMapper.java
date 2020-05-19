package com.mall.mapper;

import com.mall.pojo.User;

/**
 * @author bryin
 * @create 2020-05-19 21:40
 */
public interface UserMapper {
    /**
     * 新增用户
     * @param user 传递的用户参数对象
     */
    void addUser(User user);
}
