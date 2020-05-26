package com.mall.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author bryin
 * @create 2020-05-19 21:35
 */
@ApiModel("新增用户时传递的参数")
@Data
public class UserBo {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("手机号")
    private String telephone;
    @ApiModelProperty("邮箱")
    private String mail;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("确认密码")
    private String confirmPassword;
    @ApiModelProperty("部门id")
    private String deptId;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("备注")
    private String remark;
}
