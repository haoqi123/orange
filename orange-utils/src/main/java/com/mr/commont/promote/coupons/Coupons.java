package com.mr.commont.promote.coupons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 优惠券实体类
 * Created by haoqi on 2019/5/8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coupons {

    private Integer quanId;//'主键',
    private Integer id;//'优惠券id',
    private String name;//'优惠券名称',
    private String desc; //'介绍',
    private Integer tag;//'标签',
    private Integer min;//'最低消费',
    private Integer discount;//'满减金额',
    private Integer limit;//每人限领',
    private Integer about;//'商品使用范围',
    private Integer type; // '优惠券类型',
    private Integer status;//'状态',
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;  // '开始时间',
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTIme;  //'结束时间',
    private Integer number; //'优惠券数量',
}
