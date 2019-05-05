package com.mr.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 图片表
 * Created by haoqi on 2019/5/4.
 */
@Data
@ToString
public class PicEntry {

    //主键
    private Integer tPicId;

    //商品id
    private Integer cGoodsSn;

    //图片url
    private String picUrl;

    //图片类型
    private Integer picType;

    //加入时间
    private Date picAddTime;

}
