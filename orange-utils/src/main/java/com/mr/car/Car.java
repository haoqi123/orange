package com.mr.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    private Integer cId;
    //商品主键
    private Integer cGoodsSn;
    //主键
    private Integer tUserCarId;
    //商品信息
    private String cInformation;
    //单价
    private Double cUnitPrice;
    //数量
    private Integer cNumber;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cCreateTime;
    public String getcCreatetimes(){
        if(cCreateTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(cCreateTime);
        }
        return "";
    }
}
