package com.mr.car.mapper;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by DELL on 2019/5/6.
 */
@Mapper
public interface CarMapper {
    List queryCarList(Integer tUserCarId);
}
