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
 * 商品评论表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    //主键
    @Field("id")
    private Integer tCommentId;

    //商品编号
    @Field("c_goods_sn")
    private Integer cGoodsSn;

    //用户ID
    @Field("u_id")
    private Integer uId;

    //打分
    @Field("c_star")
    private Double cStar;

    //评论内容
    @Field("c_content")
    private String cContent;

    //评论图片
    @Field("c_pic_urls")
    private String cPicUrls;

    //创建时间
    @Field("c_add_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cAddTime;
    public String getcAddTimes(){
        if(cAddTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(cAddTime);
        }
        return "";
    }

    //类型
    @Field("c_type")
    private Integer cType;
}
