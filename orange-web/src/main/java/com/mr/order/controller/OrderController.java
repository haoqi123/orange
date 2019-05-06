package com.mr.order.controller;

import com.mr.commont.order.OrderGoods;
import com.mr.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by shangpengyu on 2019/5/5.
 */
@Controller
public class OrderController {

    //订单接口
    @Autowired
    private OrderService orderService;

    @RequestMapping("test")
    public String test(String name){
        return orderService.test(name);
    }

    @GetMapping("orderList")
    public ModelAndView orderGoods(){
        //new一个ModelAndView对象
        ModelAndView mo = new ModelAndView();

        List<OrderGoods> goodsList = orderService.orderGoodsList();

        //将数据放入到modelandview
        mo.addObject("list",goodsList);
        mo.setViewName("order/order");
        return mo;
    }
}
