package com.mr.promote.coupons.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administer on 2019/5/8.
 */
@Mapper
public interface CouponsMapper {

    /**
     * 增加
     * @return
     */
    int insertCoupons();

    /**
     * 删除
     * @return
     */
    int deleteCoupons();

    /**
     * 修改
     * @return
     */
    int updateCoupons();

    /**
     * 根据id查询
     * @param id
     */
    void selectCouponsById(Integer id);

    /**
     * 条件查询
     */
    void selectCouponsList();
}
