package com.mr.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shangpengyu on 2019/5/5.
 */
@RestController
public class OrderController {


    @RequestMapping("/test")
    public String test(){
        return "OK!";
    }

}
