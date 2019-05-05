package com.mr.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户的购物车
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCar {
    //购物车表的主键
    private Integer tUserCarId;
    //用户表的主键
    private Integer userId;
}
