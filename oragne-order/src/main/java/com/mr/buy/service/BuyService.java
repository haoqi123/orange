package com.mr.buy.service;

import com.mr.commont.buy.BuyGoods;

import java.util.List;

/**
 * Created by FHJ on 2019/5/6.
 */
public interface BuyService {
    /*
    查询商品的全部信息（根据id）和优惠劵
    */
    List<BuyGoods> queryGoods(Integer goId);
}
