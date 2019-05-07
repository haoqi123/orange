package com.mr.commont.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 商品表
 * Created by haoqi on 2019/4/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commodity {

    //商品主键
    @Field("id")
    private String commodityId;

    //类目id
    @Field("gt_id")
    private Integer gtId;

    //商品编号
    @Field("c_goods_sn")
    private Integer goodsSn;

    //商品名称
    @Field("c_name")
    private String name;

    //专柜价格
    @Field("c_counter_price")
    private Double counterPrice;

    //当前价格
    @Field("c_retail_price")
    private Double retailPrice;


    //是否热卖
    @Field("c_is_hot")
    private Integer isHot;

    //是否新品
    @Field("c_is_new")
    private Integer isNew;

    //是否在售
    @Field("c_is_on_sale")
    private Integer isOnSale;

    //关键字
    @Field("c_keywords")
    private String keywords;

    //商品单位
    @Field("c_unit")
    private Integer unit;

    //商品介绍
    @Field("c_brief")
    private String brief;

    //创建时间
    @Field("c_add_time")
    private Date addTime;

    //修改时间
    @Field("c_update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    public String getUpdateTimes(){
        if(updateTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(updateTime);
        }
        return "";
    }
    //规格
    @Field("c_spec")
    private String spec;

    //库存数量
    @Field("c_number")
    private Integer number;
}
