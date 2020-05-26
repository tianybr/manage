package com.mall.controller.v1;

import com.mall.common.JSONResult;
import com.mall.pojo.User;
import com.mall.pojo.bo.UserBo;
import com.mall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author bryin
 * @create 2020-05-19 21:47
 */
@Api(value = "用户模块接口", tags = "用户模块接口")
@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public JSONResult addUser(HttpServletRequest request, @RequestBody UserBo userBo) {
        User user = new User();
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        BeanUtils.copyProperties(userBo,user);
        user.setOperatorTime(new Date());
        user.setOperatorIp(remoteHost + ":" + remotePort);
        userService.addUser(user);
        return JSONResult.ok("添加用户成功");
    }
}
