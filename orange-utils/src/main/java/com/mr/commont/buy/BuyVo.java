package com.mr.commont.buy;

import lombok.Data;

/**
 * Created by FHJ on 2019/5/8.
 * 提交订单实体类
 */
@Data
public class BuyVo {
    //商品编号
    private Integer goodsSn;

    //商品介绍
    private String goodsInt;

    //商品描述
    private String goodsDes;

    //商品价格
    private Double goodsMoney;

    //商品数量
    private Integer goodsCount;

    //配送方式(0:包邮，1：不包邮)
    //private Integer baoyu;

    //订单总金额
    private Double orderMoney;

    //收货地址
    private Integer addressId;

    //地址是否默认（0默认，1不默认）
    private Integer usStatus;

    //物流名称
    private String logiName;


}
