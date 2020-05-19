package com.mall.controller;

import com.mall.common.JSONResult;
import com.mall.pojo.bo.UserBo;
import com.mall.pojo.validator.annotation.UserBoValidator;
import com.mall.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;

/**
 * @author bryin
 * @create 2020-05-18 15:14
 */
@RestController
@RequestMapping("/user")
@Api(tags = {"用户接口"})
@Validated
public class UserController {
    @Autowired
    private UsersService usersService;

    @ApiOperation("获取所有用户列表")
    @GetMapping("/getAllUsers")
    public JSONResult getAllUsers(){
        return JSONResult.ok(usersService.queryAll());
    }

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public JSONResult addUser(@RequestBody @Validated UserBo userBo){
        usersService.addUser(userBo);
        return JSONResult.ok();
    }
    @ApiOperation("条件查询用户")
    @PostMapping("/queryUserByCondition")
    public JSONResult queryUserByCondition(@RequestBody UserBo userBo){
        return JSONResult.ok(usersService.queryUserByCondition(userBo));
    }
}
