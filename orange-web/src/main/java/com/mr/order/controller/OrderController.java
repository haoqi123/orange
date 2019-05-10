package com.mr.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.mr.commont.order.OrderSeleVO;
import com.mr.order.service.OrderService;
import com.mr.utils.LayResult;
import com.mr.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


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

    @GetMapping("orderList")
    public ModelAndView orderGoods(@RequestParam("id") Integer id){
        //new一个ModelAndView对象
        ModelAndView mo = new ModelAndView();
        System.err.println("run");
        String string = orderService.selectOrderSeleList(id);
        LayResult<OrderSeleVO> layResult = JSONObject.parseObject(string, LayResult.class);
        //将数据放入到modelandview
        mo.addObject("list",layResult);
        mo.setViewName("/order/order");
        return mo;
    }



}
