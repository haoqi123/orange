package com.mr.car.service;

import com.mr.commont.car.Car;
import com.mr.commont.login.User;

import java.util.List;

/**
 * Created by DELL on 2019/5/6.
 */
public interface CarService {
    List queryCarList(User user);

    String addGoodsToShopping(Integer goodsId, Integer count, Integer userId);
}
