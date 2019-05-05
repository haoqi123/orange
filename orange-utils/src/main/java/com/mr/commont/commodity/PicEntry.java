package com.mr.commont.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 图片表
 * Created by haoqi on 2019/5/4.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date picAddTime;
    public String getpicAddTimes(){
        if(picAddTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(picAddTime);
        }
        return "";
    }
}
