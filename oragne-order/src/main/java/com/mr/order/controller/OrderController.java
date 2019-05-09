package com.mr.order.controller;

import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import com.mr.commont.order.OrderGoodsVo;
import com.mr.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by shangpengyu on 2019/5/5.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("orderList")
    public List<OrderGoods> getOrderList(){
        //数据库或者Redis查到的数据
        return orderService.getOrderList();
    }

    @PostMapping("addOrder")
    public OrderGoodsVo addOrder(@RequestBody OrderGoodsVo orderGoodsVo,HttpServletRequest request){
        System.err.println("run");
        System.err.println(orderGoodsVo);
        return orderService.addOrder(orderGoodsVo,request);
    }

    @PostMapping("updateOrder")
    public void updateOrderStart(String orderNo){
        orderService.updateOrderStart(orderNo);
    }

}
