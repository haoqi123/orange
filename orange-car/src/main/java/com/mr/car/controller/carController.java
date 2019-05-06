package com.mr.car.controller;

import com.mr.car.service.CarService;
import com.mr.commont.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 购物车
 * Created by DELL on 2019/5/5.
 */
@RestController
@RequestMapping("car")
public class carController {
    @Autowired
    private CarService carService;
    //添加购物车

    //打开购物车
    public ModelAndView queryCarList(Car car){
        //返回指定视图
        ModelAndView modelAndView=new ModelAndView("");
        List list=carService.queryCarList(car);
        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
