package com.mr.order.service.impl;

import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import com.mr.order.mapper.OrderMapper;
import com.mr.order.service.OrderService;
import com.mr.utils.SerializeUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shangpengyu on 2019/5/6.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StringRedisTemplate redis;


    @Override
    public List<OrderGoods> getOrderList() {

        //先从redis中回去一下数据
        String list = redis.opsForValue().get("orederList");
        //转化为list
        List<OrderGoods> list1 = JSONArray.toList(JSONArray.fromObject(list), OrderGoods.class);

        if(list1 != null){
            //如果查询出来的数据为null就走一遍数据库
            return list1;
        }else{
            //将数据库中查询到的所有数据放进redis
            List<OrderGoods> listOrder =  orderMapper.getOrderGoodsList();
            String str = JSONArray.fromObject(listOrder).toString();
            /*byte[] serialize1 = SerializeUtil.serialize(listOrder.get(0));
            String str = serialize1.toString();*/
            redis.opsForValue().set("orederList",str);
            return listOrder;
        }
    }
}
