package com.mr.domain;

import lombok.Data;
import lombok.ToString;

/**
 * 商品类目表
 * Created by haoqi on 2019/5/4.
 */
@Data
@ToString
public class GoodsTypeEntry {

    //主键
    private Integer tGoodsTypeId;

    //类目id
    private Integer gtId;

    //类目名
    private String gtName;

    //类目图标
    private String gtIconUrl;

    //类目图片
    private String gt_picUrl;

    //关键字
    private String gtKeywords;

    //简介
    private String gtDesc;

    //级别
    private Integer gtLevel;
}
