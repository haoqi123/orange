package com.mr.order.mapper;

import com.mr.commont.order.Logistics;
import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import com.mr.commont.order.OrderSeleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by shangpengyu on 2019/5/6.
 */
@Mapper
public interface OrderMapper {
    //查询订单商品
    List<OrderGoods> getOrderGoodsList();

    //生成订单
    void addOrder(Order order);

    //生成订单商品
    void addOrderGoods(OrderGoods orderGoods);

    //生成物流表
    void addLogistics(Logistics logistics);

    //修改订单状态
    void updateOrder(String orderNo);

    /**
     * 根据用户id查询订单
     * @param id
     * @return
     */
    List<OrderSeleVO> selectOrderSeleList(Integer id);

}
