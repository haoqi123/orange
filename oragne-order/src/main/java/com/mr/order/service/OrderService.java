package com.mr.order.service;

import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;

import java.util.List;

/**
 * Created by shangpengyu on 2019/5/6.
 */
public interface OrderService {

    List<OrderGoods> getOrderList();

}
