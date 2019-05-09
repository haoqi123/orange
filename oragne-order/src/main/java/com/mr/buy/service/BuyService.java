package com.mr.buy.service;

import com.mr.commont.buy.Address;
import com.mr.commont.buy.BuyGoods;
import com.mr.commont.buy.Coupopn;

import java.util.List;
import java.util.Set;

/**
 * Created by FHJ on 2019/5/6.
 */
public interface BuyService {
    /*
    查询商品的全部信息（根据id）和优惠劵
    */

    List<BuyGoods> selectGoods(Integer goId);

    Set<Address> selectAddress(Integer goId);

    List<Coupopn> selectCoupon(Integer goId);
}
