package com.mr.order.service;

import com.mr.commont.order.OrderGoods;
import com.mr.commont.order.OrderGoodsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by shangpengyu on 2019/5/5.
 */
@FeignClient(value="ORANGE-ORDER")
public interface OrderService {
    
    @RequestMapping("test")
    String test(@RequestParam("name") String name);

    @GetMapping("orderList")
    List<OrderGoods> orderGoodsList();

    @PostMapping("addOrder")
    void addOrder(OrderGoodsVo orderGoodsVo);

}
