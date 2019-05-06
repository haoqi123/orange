package com.mr.order.service.impl;

import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import com.mr.order.mapper.OrderMapper;
import com.mr.order.service.OrderService;
import com.mr.utils.SerializeUtil;
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
        //将获取的数据序列化
        byte[] serialize = SerializeUtil.serialize(list);
        //将序列化的数据强转为对象集合
        List<OrderGoods> unserialize = (List<OrderGoods>) SerializeUtil.unserialize(serialize);
        if(unserialize != null){
            //如果查询出来的数据为null就走一遍数据库
            return unserialize;
        }else{
            //将数据库中查询到的所有数据放进redis
            List<OrderGoods> listOrder =  orderMapper.getOrderGoodsList();
            System.out.println("1112233"+listOrder.get(0));
            byte[] serialize1 = SerializeUtil.serialize(listOrder.get(0));

            String str = serialize1.toString();
            redis.opsForValue().set("orederList",str);
            return listOrder;
        }
    }
}
