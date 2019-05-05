package com.mr.commont.search;

import lombok.Data;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * 商品表
 * Created by haoqi on 2019/4/30.
 */
@Data
@ToString
public class SearchEntry {

    //商品主键
    @Field("id")
    private Integer tCommodityId;

    //类目id
    @Field("gt_id")
    private Integer gtId;

    //商品编号
    @Field("c_goods_sn")
    private Integer cGoodsSn;

    //商品名称
    @Field("c_name")
    private String cName;

    //专柜价格
    @Field("c_counter_price")
    private Double cCounterPrice;

    //当前价格
    @Field("c_retail_price")
    private Double cRetailPrice;


    //是否热卖
    @Field("c_is_hot")
    private Integer cIsHot;

    //是否新品
    @Field("c_is_new")
    private Integer cIsNew;

    //是否在售
    @Field("c_is_on_sale")
    private Integer cIsOnSale;

    //关键字
    @Field("c_keywords")
    private String cKeywords;

    //商品单位
    @Field("c_unit")
    private Integer cUnit;

    //商品介绍
    @Field("c_brief")
    private String cBrief;

    //创建时间
    @Field("c_add_time")
    private Date cAddTime;

    //修改时间
    @Field("c_update_time")
    private Date cUpdateTime;

    //规格
    @Field("c_spec")
    private String cSpec;

    //库存数量
    @Field("c_number")
    private Integer cNumber;
}
