package com.mr.commont.buy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by FHJ on 2019/5/8.
 * 个人收货地址
 */
@Data
@AllArgsConstructor
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor
//使用后创建一个无参构造函数
@ToString
public class Address {

    /*t_useraddress_id     int not null comment '主键',
   `user_id`            int not null comment '用户编号',
   qu_id                int not null comment '地址编号',
   us_name              varchar(20) not null comment '收货人名称',
   us_phone             varchar(11) not null comment '收货地址手机号',
   us_status            int not null comment '是否默认',*/
    //地址表主键
    private Integer usAdId;

    //用户编号
    private Integer userId;

    //地址编号
    private Integer quId;

    //收货人名称
    private String usName;

    //收货地址手机号
    private String usPhone;

    //是否默认(0默认，1不默认)
    private Integer usStatus;

}
