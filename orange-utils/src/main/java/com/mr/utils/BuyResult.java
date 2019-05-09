package com.mr.utils;

import com.mr.commont.buy.Address;
import com.mr.commont.buy.BuyGoods;
import com.mr.commont.buy.Coupopn;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Created by FHJ on 2019/5/8.
 *  商品，优惠券，地址
 */
@Data
public class BuyResult {

    /*
     *   商品集合
     */
    private List<BuyGoods>buyGoodsList;

    /*
    *   优惠券
    */
    private List<Coupopn>coupopnsList;
    /*
    *   收货地址
    */
    private Set<Address>addressSet;
}
