package com.mr.order.controller;

import com.mr.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shangpengyu on 2019/5/5.
 */
@RestController
public class OrderController {

    //订单接口
    @Autowired
    private OrderService orderService;

    @RequestMapping("test")
    public String test(String name){
        return orderService.test(name);
    }

    @RequestMapping("orderList")
    public void orderGoods(){
        orderService.orderGoodsList();
    }
}
