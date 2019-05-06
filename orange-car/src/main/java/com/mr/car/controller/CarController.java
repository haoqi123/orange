package com.mr.car.controller;

import com.mr.car.service.CarService;
import com.mr.commont.car.Car;
import com.mr.utils.LayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public LayResult addCar(){
        return null;
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
