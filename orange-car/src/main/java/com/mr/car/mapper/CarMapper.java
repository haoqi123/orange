package com.mr.car.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by DELL on 2019/5/6.
 */
@Mapper
public interface CarMapper {

    List queryCarList(Integer tUserCarId);

    String addGoodsToShopping(Integer goodsId, Integer count, Integer userId);
}
