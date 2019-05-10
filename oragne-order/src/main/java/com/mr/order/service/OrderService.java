package com.mr.order.service;

import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import com.mr.commont.order.OrderGoodsVo;
import com.mr.commont.order.OrderSeleVO;
import com.mr.utils.LayResult;
import com.mr.utils.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by shangpengyu on 2019/5/6.
 */
public interface OrderService {

    List<OrderGoods> getOrderList();


    //生成订单
    OrderGoodsVo addOrder(OrderGoodsVo orderGoodsVo,HttpServletRequest request);


    //修改订单状态
    void updateOrderStart(String orderNo);


    /**
     * 根据用户id查询订单
     * @param id
     * @return
     */
    LayResult<OrderSeleVO> selectOrderSeleList(Integer id);
}
