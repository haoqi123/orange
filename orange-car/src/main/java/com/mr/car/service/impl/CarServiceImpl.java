package com.mr.car.service.impl;

import com.mr.car.mapper.CarMapper;
import com.mr.car.service.CarService;
import com.mr.commont.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DELL on 2019/5/6.
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;
    @Override
    public List queryCarList(Car car) {
        return carMapper.queryCarList(car.getTUserCarId());
    }

    @Override
    public String addGoodsToShopping(Integer goodsId, Integer count, Integer userId) {
        return carMapper.addGoodsToShopping(goodsId,count,userId);
    }
}
