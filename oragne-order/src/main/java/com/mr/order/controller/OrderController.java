package com.mr.order.controller;

import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import com.mr.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by shangpengyu on 2019/5/5.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("orderList")
    public ModelAndView getOrderList(){
        //new一个ModelAndView对象
        ModelAndView mo = new ModelAndView();
        //数据库或者Redis查到的数据
        List<OrderGoods> list = orderService.getOrderList();
        //将数据放入到modelandview
        mo.addObject("list",list);
        mo.setViewName("");
        return null;
    }

}
