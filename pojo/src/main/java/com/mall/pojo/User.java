package com.mall.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author bryin
 * @create 2020-05-19 21:31
 */
@Data
public class User {
    private String id;
    private String username;
    private String telephone;
    private String mail;
    private String password;
    private String deptId;
    private Integer status;
    private String remark;
    private String operator;
    private Date operatorTime;
    private String operatorIp;

}
