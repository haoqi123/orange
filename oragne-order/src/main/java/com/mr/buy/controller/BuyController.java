package com.mr.buy.controller;

import com.mr.buy.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by FHJ on 2019/5/6.
 * 购买前台项目接口
 */
@RestController
public class BuyController {
    @Autowired
    private BuyService buyService;

    @RequestMapping("buyPage")
    public ModelAndView buyPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/buy/buy");
        return mv;
    }

}
