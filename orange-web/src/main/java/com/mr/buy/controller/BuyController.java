package com.mr.buy.controller;

import com.mr.buy.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2019/5/6.
 * 购买前台项目页面跳转
 */
@RestController
@RequestMapping("buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    ModelAndView mv = new ModelAndView();

    /*查询商品优惠券返回购买页面*/
    @RequestMapping("queryGoods")
    public ModelAndView queryGoods(Integer id) {
        String s = buyService.queryGoods(id);
        System.out.println(s);
        mv.addObject("result", s);
        mv.setViewName("/buy/buy");
        return mv;
    }
    /*去商品购买页面*/
    @RequestMapping("buyPage")
    public ModelAndView buyPage(){
        //ModelAndView mv = new ModelAndView();
        mv.setViewName("/buy/buy");
        return mv;
    }

    /*去登陆界面*/
    @RequestMapping("login")
    public ModelAndView loginPage(){
        //ModelAndView mv = new ModelAndView();
        mv.setViewName("/login/login");
        return mv;
    }

    /*去注册界面*/
    @RequestMapping("register")
    public ModelAndView registerPage(){
        //ModelAndView mv = new ModelAndView();
        mv.setViewName("");
        return mv;
    }

    /*去购物车页面*/
    @RequestMapping("car")
    public ModelAndView carPage(){
        //ModelAndView mv = new ModelAndView();
        mv.setViewName("/car/shopcart");
        return mv;
    }

    /*去足迹*/
    @RequestMapping("foot")
    public ModelAndView footPage(){
        //ModelAndView mv = new ModelAndView();
        mv.setViewName("/foot/foot");
        return mv;
    }
    /*去首页*/
    @RequestMapping("index")
    public ModelAndView indexPage(){
        //ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        return mv;
    }
    /*商品结算页面*/
    @RequestMapping("puy")
    public ModelAndView puyPage(){
        //ModelAndView mv = new ModelAndView();
        //调用个人管理中心收货地址的查询接口
        //调用后台管理物流的查询
        //调用提供者提供的查询商品的详情（包含优惠券）
        mv.setViewName("/buy/settle");
        return mv;
    }
}
