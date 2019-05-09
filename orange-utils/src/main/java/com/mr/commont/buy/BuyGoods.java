package com.mr.commont.buy;

import lombok.Data;

import java.util.Date;

/**
 * Created by FHJ on 2019/5/8.
 * 从数据库查询的商品详情和优惠劵（以后可以直接从商品详情页面获取，不再查询数据库）
 */
@Data
public class BuyGoods {

    //商品主键
    private String commodityId;

    //类目id
    private Integer gtId;

    //商品编号
    private Integer goodsSn;

    //商品描述
    private String goodsInt;

    //商品价格
    private Double goodsMoney;

    //配送方式(0:包邮，1：不包邮)
    //private Integer baoyu;

    //收货地址(在订单介绍表加上地址的id作为外键)
    private Integer addressId;

    //优惠券id
    private Integer qId;

    //优惠券状态（0：停用（失效）1：可用(有效)）
    private Integer qStatus;

    //优惠券开始时间
    private Date qCreateTime;

    //优惠券结束时间
    private Date qEndTime;

    //优惠券使用范围（0：全场通用 1：指定分类（目前不支持）2：指定商品（目前不支持））
    private Integer qAbout;
    //
    //
    //
    //



}
