package com.mall.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author bryin
 * @create 2020-05-18 15:20
 */
@Data
public class Users {

    private String id;
    @TableField("username")
    private String userName;
    private String password;
    @TableField("nickname")
    private String nickName;
    @TableField("realname")
    private String realName;
    private String face;
    private String mobile;
    private String email;
    private Integer sex;
    private Date birthday;
    private Date createdTime;
    private Date updatedTime;
}
