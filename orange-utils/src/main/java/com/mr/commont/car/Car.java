package com.mr.commont.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DELL on 2019/5/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    //主键
    @Field("id")
    private Integer cId;
    //商品主键
    @Field("c_goods_sn")
    private Integer cGoodsSn;
    //主键
    @Field("t_user_car_id")
    private Integer tUserCarId;
    //商品信息
    @Field("c_information")
    private String cInformation;
    //单价
    @Field("c_unit_price")
    private Double cUnitPrice;
    //数量
    @Field("c_number")
    private Integer cNumber;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Field("c_createTime")
    private Date cCreateTime;
    public String getcCreatetimes(){
        if(cCreateTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(cCreateTime);
        }
        return "";
    }
}
