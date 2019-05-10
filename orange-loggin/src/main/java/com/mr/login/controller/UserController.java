package com.mr.login.controller;

import com.mr.commont.login.User;
import com.mr.commont.login.UserVo;
import com.mr.login.service.UserService;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 师利梅 on 2019/5/6.
 */
@RestController
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
    public ResultVo addUser(@RequestBody User user){
        System.out.println(user);
        return userService.addUser(user);
    }

    //验证码
    @RequestMapping("/yanZhengMa")
    public String yanZhengMa(String userName){
        return userService.yanZhengMa(userName);
    }

    //登录
    @RequestMapping("tologin")
    @ResponseBody
    public ResultVo tologin(@RequestBody UserVo userVo,HttpServletRequest request){
        //将数据提交到业务层
        return userService.tologin(userVo,request);
    }

    //个人资料
    @RequestMapping("selectUser/{userName}")
    @ResponseBody
    public User selectUser(@PathVariable(value = "userName")String userName){
        return userService.selectUser(userName);
    }

}
