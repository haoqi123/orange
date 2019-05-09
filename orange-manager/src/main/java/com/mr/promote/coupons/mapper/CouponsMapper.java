package com.mr.promote.coupons.mapper;

import com.mr.commont.promote.coupons.Coupons;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administer on 2019/5/8.
 */
@Component
@Mapper
public interface CouponsMapper {

    /**
     * 增加
     * @return
     */
    int insertCoupons(@Param("coupons") Coupons coupons);

    /**
     * 删除
     * @return
     */
    int deleteCoupons(Integer id);

    /**
     * 修改
     * @return
     */
    int updateCoupons(@Param("coupons") Coupons coupons);

    /**
     * 根据id查询
     * @param id
     */
    Coupons selectCouponsById(Integer id);

    /**
     * 条件查询
     */
    List<Coupons> selectCouponsList(Coupons coupons);
}
