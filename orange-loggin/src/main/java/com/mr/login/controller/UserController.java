package com.mr.login.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * Created by 师利梅 on 2019/5/5.
 */
@RestController
public class UserController {

    @Value("${server.port}")
    String port;

    @RequestMapping("hello")
    public String hello(String name){
        return  "hello" + name + " ,i am from port: "+port;
    }
}
