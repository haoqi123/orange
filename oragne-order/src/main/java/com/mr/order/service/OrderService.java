package com.mr.order.service;

import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import com.mr.commont.order.OrderGoodsVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by shangpengyu on 2019/5/6.
 */
public interface OrderService {

    List<OrderGoods> getOrderList();


    //生成订单
    void addOrder(OrderGoodsVo orderGoodsVo,HttpServletRequest request);

}
