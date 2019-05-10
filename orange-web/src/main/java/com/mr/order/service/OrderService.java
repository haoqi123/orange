package com.mr.order.service;

import com.mr.commont.order.OrderGoods;
import com.mr.commont.order.OrderGoodsVo;
import com.mr.utils.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
    OrderGoodsVo addOrder(OrderGoodsVo orderGoodsVo);

    @PostMapping("updateOrder")
    void updateOrderStart(@RequestParam("orderNo")String orderNo);

    @GetMapping("selectOrderSeleList")
    String selectOrderSeleList(@RequestParam("id")Integer id);
}
