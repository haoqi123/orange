package com.mr.promote;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administer on 2019/5/8.
 */
@RestController
@RequestMapping("PromoteController")
public class PromoteController {

    @RequestMapping("couponsFtl")
    public ModelAndView couponsFtl(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/promote/coupons");
        return modelAndView;
    }

    @RequestMapping("killFtl")
    public ModelAndView killFtl(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/promote/kill");
        return modelAndView;
    }
}
