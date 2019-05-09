package com.mr.order.service.impl;

import com.mr.commont.order.Logistics;
import com.mr.commont.order.Order;
import com.mr.commont.order.OrderGoods;
import com.mr.commont.order.OrderGoodsVo;
import com.mr.order.mapper.OrderMapper;
import com.mr.order.service.OrderService;
import com.mr.utils.SerializeUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by shangpengyu on 2019/5/6.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StringRedisTemplate redis;

    private Order order = new Order();

    private OrderGoods orderGoods = new OrderGoods();

    private Logistics logistics = new Logistics();


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

    //生成未支付订单
    //修改未支付订单状态
    @Override
    public OrderGoodsVo addOrder(OrderGoodsVo orderGoodsVo,HttpServletRequest request) {
        //如何保证再次访问这个方法的时候是修改订单状态，如果客户端改变了要购买的商品就需要从新生成一个订单
        //这种情况如何判断
        //判断实体类里的start属性，判断如果有值就是生成一个待支付订单
        //如果没值就是一个修改订单支付状态
        //前台的start状态传1，并且没有订单号 说明生成一个未支付顶单
        if (orderGoodsVo.getStart() == 1 && orderGoodsVo.getOrderNo() == null) {
            //随机生成一个订单号
            order.setOrderNo((int) (Math.random() * 999999));
            //给订单总金额赋值
            order.setOrderMoney(orderGoodsVo.getOrderMoney());
            //给订单邮费赋值
            order.setOrderPostage(orderGoodsVo.getOrderPostage());
            //给订单赋值
            order.setUserId(1);
            //订单生成时间 当前时间
            order.setOrderGanerationTime(new Date());
            ////订单状态
            order.setOrderType(0);
            //订单是否过时
            order.setOrderInvalid(1);
            //给订单商品赋值
            //商品编号
            orderGoods.setCGoodsSn(orderGoodsVo.getCGoodsSn());
            //订单商品中的订单编号
            orderGoods.setOrderNo(order.getOrderNo());
            //给商品介绍赋值
            orderGoods.setOrderGoodsIntroduce(orderGoodsVo.getOrderGoodsIntroduce());
            //商品描述
            orderGoods.setOrderGoodsDescribe(orderGoodsVo.getOrderGoodsDescribe());
            //商品价格
            orderGoods.setOrderGoodsMoney(orderGoodsVo.getOrderGoodsMoney());
            //商品数量
            orderGoods.setOrderGoodsNum(orderGoodsVo.getOrderGoodsNum());
            //给物流订单赋值
            //付给物流订单号
            logistics.setOrderNo(order.getOrderNo());
            //物流名称
            logistics.setLogiName(orderGoodsVo.getLogiName());
            //随机生成一个物流编号
            logistics.setLogiNo(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
            //去数据库生成订单
            orderMapper.addOrder(order);
            //生成订单商品
            orderMapper.addOrderGoods(orderGoods);
            //生成物流表
            orderMapper.addLogistics(logistics);

            //给goodsVo中的订单号赋值返回给前台
            orderGoodsVo.setOrderNo(order.getOrderNo());
            return orderGoodsVo;
            //如果前台start传递的参数是0，订单号不为空那就说明要修改订单位已经支付状态
        }else{
            //调用修改方法
            updateOrderStart(orderGoodsVo.getOrderNo().toString());
            return orderGoodsVo;
        }
    }
    @Override
    public void updateOrderStart(String orderNo) {
        orderMapper.updateOrder(orderNo);
    }


}
