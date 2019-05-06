package com.mr.order.mapper;

import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by shangpengyu on 2019/5/6.
 */
@Mapper
public interface OrderMapper {

    List<OrderGoods> getOrderGoodsList();

}
