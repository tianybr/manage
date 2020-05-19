package com.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.pojo.Users;
import com.mall.pojo.bo.UserBo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bryin
 * @create 2020-05-18 15:20
 */
@Repository
public interface UserMapper extends BaseMapper<Users> {
    /**
     * 添加新用户
     * @param userBo
     */
    void addUser(UserBo userBo);

    /**
     * 条件查询用户
     * @param  userBo
     * @return List<Users>
     */
    List<Users> queryUserByCondition(UserBo userBo);
}
