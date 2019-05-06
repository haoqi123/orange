package com.mr.buy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2019/5/6.
 * 购买前台项目页面跳转
 */
@RestController
public class BuyController {

    @RequestMapping("buyPage")
    public ModelAndView buyPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/buy/buy");
        return mv;
    }
}
