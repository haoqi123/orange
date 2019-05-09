package com.mr.buy.service.impl;

import com.mr.buy.mapper.BuyMapper;
import com.mr.buy.service.BuyService;
import com.mr.commont.buy.BuyGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FHJ on 2019/5/7.
 *
 */
@Service
public class BuyServiceImpl implements BuyService{
    @Autowired
    private BuyMapper buyMapper;
    /*
    查询商品的全部信息（根据id）和优惠劵
    */
    @Override
    public List<BuyGoods> queryGoods(Integer goId) {

        List<BuyGoods> queryGoods = new ArrayList<BuyGoods>();

        BuyGoods goods = buyMapper.queryGoods(goId);

        BuyGoods coupopn =buyMapper.queryCoupopn(goId);

        queryGoods.add(goods);
        queryGoods.add(coupopn);

        return queryGoods;
    }
}
