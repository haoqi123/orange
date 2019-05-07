package com.mr.car.controller;

import com.mr.car.service.CarService;
import com.mr.commont.car.Car;
import com.mr.commont.login.User;
import com.mr.utils.LayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车
 * Created by DELL on 2019/5/5.
 */
@RestController
public class CarController {
    @Autowired
    private CarService carService;
    //添加购物车
    @RequestMapping(value = "addCar",method = RequestMethod.POST)
    public ModelAndView addCar(Integer goodsId,Integer count, HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        Map<String,Object> map = new HashMap();
        //获取当前用户
        User user = (User) session.getAttribute("userSession");
        //用户必须登陆
        if(user==null){
            modelAndView.setViewName("/login/login");
            return modelAndView;
        }else {
            String list = carService.addGoodsToShopping(goodsId, count, user.getUserId());
            modelAndView.addObject("list",list);
        }
        return modelAndView;
    }
    //打开购物车
    @RequestMapping(value = "queryCarList",method = RequestMethod.GET)
    public ModelAndView queryCarList(Car car){
        //返回指定视图
        ModelAndView modelAndView=new ModelAndView("/car/shopcart");
        List list=carService.queryCarList(car);
        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
