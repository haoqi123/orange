package com.mr.commont.buy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by FHJ on 2019/5/8.
 * 优惠券实体类（个人账户的实体类）
 */
@Data
@AllArgsConstructor
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor
//使用后创建一个无参构造函数
@ToString
public class Coupopn {

    //用户id
    private Integer userId;

    //优惠券id
    private Integer qId;

    //个人优惠券使用状态（0：停用（失效）1：可用(有效)）
    private Integer userquanStatus;

    //优惠券状态（0：停用（失效）1：可用(有效)）
    private Integer qStatus;

    //优惠券开始时间
    private Date qCreateTime;

    //优惠券结束时间
    private Date qEndTime;

    //优惠券使用范围（0：全场通用 1：指定分类（目前不支持）2：指定商品（目前不支持））
    private Integer qAbout;
}
