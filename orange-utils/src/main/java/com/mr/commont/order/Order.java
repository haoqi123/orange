package com.mr.commont.order;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/5/5.
 * 订单实体类
 */
@Data
public class Order {

    private Integer orderId;

    private Integer userId;

    //订单号
    private Integer orderNo;

    //邮费
    private Double orderPostage;

    //总金额
    private Double orderMoney;

    //订单生成时间
    private Date orderGanerationTime;

    //付款时间
    private Date orderForceTime;

    //订单状态//0待支付 1已支付
    private Integer orderType;

    //订单是否过时 0过时 1为过时
    private Integer orderInvalid;


}
