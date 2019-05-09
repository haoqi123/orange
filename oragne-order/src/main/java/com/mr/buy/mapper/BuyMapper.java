package com.mr.buy.mapper;

import com.mr.commont.buy.Address;
import com.mr.commont.buy.BuyGoods;
import com.mr.commont.buy.Coupopn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by FHJ on 2019/5/7.
 */
@Mapper
@Component
public interface BuyMapper {
    /*
    *查询用户的优惠券
    * */
    List<Coupopn> queryCoupopn(Integer goId);

    /**
     *查询商品
     * @param goId
     * @return
     */
    List<BuyGoods> queryGoods(Integer goId);

    /*
     用户查询地址列表
     */
    Set<Address> queryAddress(Integer goId);

}
