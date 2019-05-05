package com.mr.login.controller;

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

    @Value("${server.port}")
    String port;

    @RequestMapping("login")
    public ModelAndView tologin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login/login");
        return mv;
    }
}
