package com.mr.login.controller;

import com.mr.commont.login.User;
import com.mr.login.service.UserService;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 师利梅 on 2019/5/6.
 */
@RequestMapping
public class UserController {

    @Value("${server.port}")
    String port;

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param user
     * @return
     */
    @RequestMapping("addUser")
    @ResponseBody
    public ResultVo addUser(User user){
        return userService.addUser(user);
    }
}
