package com.mall.pojo.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mall.pojo.validator.annotation.UserBoValidator;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author bryin
 * @create 2020-05-18 17:06
 */
@Data
@UserBoValidator
public class UserBo {
    private String id;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    private String password;
    private String face;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date createdTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date updatedTime;
}
