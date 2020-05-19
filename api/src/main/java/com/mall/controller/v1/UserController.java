package com.mall.controller.v1;

import com.mall.common.JSONResult;
import com.mall.pojo.bo.UserBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bryin
 * @create 2020-05-19 21:47
 */
@Api(value = "用户模块接口",tags = "用户模块接口")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public JSONResult addUser(HttpServletRequest request, @RequestBody UserBo userBo){

        return JSONResult.ok("添加用户成功");
    }
}
