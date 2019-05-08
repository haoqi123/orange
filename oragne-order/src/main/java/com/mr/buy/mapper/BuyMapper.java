package com.mr.buy.mapper;

import com.mr.commont.buy.BuyGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by FHJ on 2019/5/7.
 */
@Mapper
@Component
public interface BuyMapper {
    /*
    *查询用户的优惠券
    * */
    BuyGoods queryCoupopn(Integer goId);

    /**
     *查询商品
     * @param goId
     * @return
     */
    BuyGoods queryGoods(Integer goId);
}
