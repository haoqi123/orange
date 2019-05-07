package com.mr.car.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mr.car.service.CarService;
import com.mr.commont.login.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 购物车
 * Created by DELL on 2019/5/5.
 */
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

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
    public ModelAndView queryCarList(User user){
        //查看redis里是否有
        String carList = (String)redisTemplate.opsForValue().get("carList");
        //返回指定视图
        ModelAndView modelAndView=new ModelAndView("/car/shopcart");
        if(carList==null){
            //数据库查询
            List list=carService.queryCarList(user);
            String s = JSONObject.toJSONString(list);
            //数据库查询出来在放入redis里
            redisTemplate.opsForValue().set("carList", s);
            amqpTemplate.convertAndSend("test_queue",s);
            modelAndView.addObject("list",list);
            return modelAndView;
        }else{
            System.out.println("carList:" + carList);
            List<String> s = Arrays.asList(carList);
            modelAndView.addObject("list",s);
            return modelAndView;
        }
    }
}
