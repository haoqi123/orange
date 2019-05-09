package com.mr.promote.coupons.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mr.commont.promote.coupons.Coupons;
import com.mr.promote.coupons.service.CouponsService;
import com.mr.utils.LayResult;
import com.mr.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haoqi on 2019/5/8.
 */
@RestController
@RequestMapping("CouponsController")
public class CouponsController {

    @Autowired
    private CouponsService service;

    /**
     * 增加
     *
     * @param coupons
     * @return
     */
    @RequestMapping("insertCoupons")
    public int insertCoupons(Coupons coupons) {
        return service.insertCoupons(coupons);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteCoupons")
    public int deleteCoupons(Integer id) {
        return service.deleteCoupons(id);
    }

    /**
     * 修改
     *
     * @param coupons
     * @return
     */
    @RequestMapping("updateCoupons")
    public int updateCoupons(Coupons coupons) {
        return service.updateCoupons(coupons);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping("selectCouponsById")
    public Coupons selectCouponsById(Integer id) {
        return service.selectCouponsById(id);
    }

    /**
     * 条件查询
     *
     * @param coupons
     * @param page
     * @return
     */
    @RequestMapping("selectCouponsList")
    public LayResult<Coupons> selectCouponsList(Coupons coupons, Page page) {
        return service.selectCouponsList(coupons, page);
    }
}
