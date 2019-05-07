package com.mr.login.controller;

import com.mr.commont.login.User;
import com.mr.login.service.UserService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by 师利梅 on 2019/5/5.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public ModelAndView tologin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login/login");
        return mv;
    }

    @RequestMapping("addUser")
    public String addUser(User user){
        return userService.addUser(user);
    }

}
