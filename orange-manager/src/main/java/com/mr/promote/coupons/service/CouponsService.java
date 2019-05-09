package com.mr.promote.coupons.service;

import com.mr.commont.promote.coupons.Coupons;
import com.mr.utils.LayResult;
import com.mr.utils.Page;

import java.util.List;

/**
 * Created by Administer on 2019/5/8.
 */
public interface CouponsService {

    /**
     * 增加
     * @return
     */
    int insertCoupons(Coupons coupons);

    /**
     * 删除
     * @return
     */
    int deleteCoupons(Integer id);

    /**
     * 修改
     * @return
     */
    int updateCoupons(Coupons coupons);

    /**
     * 根据id查询
     * @param id
     */
    Coupons selectCouponsById(Integer id);

    /**
     * 条件查询
     */
    LayResult<Coupons> selectCouponsList(Coupons coupons, Page page);
}
