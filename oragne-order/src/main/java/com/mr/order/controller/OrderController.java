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

    @Autowired
    private OrderService orderService;




}
