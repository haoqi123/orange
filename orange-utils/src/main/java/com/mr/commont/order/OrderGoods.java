package com.mr.commont.order;

import lombok.Data;

/**
 * Created by shangpengyu on 2019/5/6.
 */
@Data
public class OrderGoods {

    private Integer orderGoodsId;

    //订单编号
    private Integer orderNo;

    //商品主键
    private Integer cGoodsSn;

    //商品介绍
    private String orderGoodsIntroduce;

    //商品描述
    private String orderGoodsDescribe;

    //商品价格
    private Double orderGoodsMoney;

    //商品数量
    private Integer orderGoodsNum;

    @Override
    public String toString() {
        return "OrderGoods{" +
                "orderGoodsId=" + orderGoodsId +
                ", orderNo=" + orderNo +
                ", cGoodsSn=" + cGoodsSn +
                ", orderGoodsIntroduce='" + orderGoodsIntroduce + '\'' +
                ", orderGoodsDescribe='" + orderGoodsDescribe + '\'' +
                ", orderGoodsMoney=" + orderGoodsMoney +
                ", orderGoodsNum=" + orderGoodsNum +
                '}';
    }
}
