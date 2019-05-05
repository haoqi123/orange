package com.mr.commont.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    private Integer tCommentId;

    //商品编号
    private Integer cGoodsSn;

    //用户ID
    private Integer uId;

    //打分
    private Double cStar;

    //评论内容
    private String cContent;

    //评论图片
    private String cPicUrls;

    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cAddTime;
    public String getcAddTimes(){
        if(cAddTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(cAddTime);
        }
        return "";
    }

    //类型
    private Integer cType;
}
