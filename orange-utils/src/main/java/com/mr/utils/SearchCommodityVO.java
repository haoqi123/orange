package com.mr.utils;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administer on 2019/5/7.
 */
@Data
public class SearchCommodityVO {
    //商品主键
    private String commodityId;

    //类目id
    private Integer gtId;

    //商品编号
    private Integer goodsSn;

    //商品名称
    private String name;

    //专柜价格
    private Double counterPrice;

    //当前价格
    private Double retailPrice;


    //是否热卖
    private Integer isHot;

    //是否新品
    private Integer isNew;

    //是否在售
    private Integer isOnSale;

    //关键字
    private String keywords;

    //商品单位
    private Integer unit;

    //商品介绍
    private String brief;

    //库存数量
    private Integer number;

    //图片url
    private String picUrl;

    //图片类型
    private Integer picType;

    /**
     * 参数集合
     */
    private Map<String,Set<String>> parameterSet;
}
