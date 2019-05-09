package com.mr.promote;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.mr.commont.promote.coupons.Coupons;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("couponAddFtl")
    public ModelAndView couponAddFtl(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/promote/coupons/coupoonsadd");
        return modelAndView;
    }

    @RequestMapping("couponSeleFtl")
    public ModelAndView couponSeleFtl(Coupons coupons){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("coupons",coupons);
        modelAndView.setViewName("/promote/coupons/couponssele");
        return modelAndView;
    }

    @RequestMapping("couponUpdateFtl")
    public ModelAndView couponUpdateFtl(Coupons coupons){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("coupons",coupons);
        modelAndView.setViewName("/promote/coupons/coupoonsupdate");
        return modelAndView;
    }
}
