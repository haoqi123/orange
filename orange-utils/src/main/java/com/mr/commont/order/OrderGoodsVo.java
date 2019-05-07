package com.mr.commont.order;

import lombok.Data;

/**商品Vo
 * Created by shangpengyu on 2019/5/7.
 */
@Data
public class OrderGoodsVo {

    //商品编号
    private Integer cGoodsSn;

    //订单商品介绍
    private String orderGoodsIntroduce;

    //订单商品描述
    private String orderGoodsDescribe;

    //商品价格
    private Double orderGoodsMoney;

    //邮费
    private Double orderPostage;

    //总金额
    private Double orderMoney;

    //物流名称
    private String logiName;


}
