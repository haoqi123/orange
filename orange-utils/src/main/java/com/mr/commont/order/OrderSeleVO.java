package com.mr.commont.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 订单详情VO
 * Created by haoqi on 2019/5/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderSeleVO {

    private Integer orderNo;//订单标号
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderForceTime;//付款时间
    private Integer userId;//用户id
    private Integer type;//订单状态
    private Integer invaslid;//是否失效
    private Double orderMoney;//订单总价格

    private List<OrderSeleGoodsVO> orderSeleGoodsVOList;

}
