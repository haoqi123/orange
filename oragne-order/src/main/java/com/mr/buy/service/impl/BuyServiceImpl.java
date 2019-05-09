package com.mr.buy.service.impl;

import com.mr.buy.mapper.BuyMapper;
import com.mr.buy.service.BuyService;
import com.mr.commont.buy.Address;
import com.mr.commont.buy.BuyGoods;
import com.mr.commont.buy.Coupopn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by FHJ on 2019/5/7.
 *
 */
@Service
public class BuyServiceImpl implements BuyService{
    @Autowired
    private BuyMapper buyMapper;


    @Override
    public List<BuyGoods> selectGoods(Integer goId) {
        return buyMapper.queryGoods(goId);
    }

    @Override
    public Set<Address> selectAddress(Integer goId) {
        return buyMapper.queryAddress(goId);
    }

    @Override
    public List<Coupopn> selectCoupon(Integer id) {
        return buyMapper.queryCoupopn(id);
    }
    /*
    查询商品的全部信息（根据id）和优惠劵
    */

}
