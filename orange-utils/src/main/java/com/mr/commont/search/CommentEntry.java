package com.mr.commont.search;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 商品评论表
 * Created by haoqi on 2019/5/4.
 */
@Data
@ToString
public class CommentEntry {

    //主键
    private Integer tCommentId;

    //商品编号
    private Integer cGoodsSn;

    //用户id
    private Integer uId;

    //打分
    private Double cStar;

    //评论内容
    private String cContent;

    //评论图片
    private String cPicUrls;

    //创建时间
    private Date cAddTime;

    //类型
    private Integer cType;
}
