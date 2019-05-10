package com.mr.commont.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单商品详情
 * Created by haoqi on 2019/5/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderSeleGoodsVO {
    private Integer id;//主键
    private String commodityName;//商品名称
    private String orderGoodsIntroduce;//订单商品介绍
    private String orderGoodsDescribe;//订单商品描述
    private Double orderGoodsMoney;//订单商品价格
    private Integer goodsNum;//商品数量
}
