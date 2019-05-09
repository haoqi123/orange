package com.mr.promote.coupons.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mr.commont.promote.coupons.Coupons;
import com.mr.promote.coupons.mapper.CouponsMapper;
import com.mr.promote.coupons.service.CouponsService;
import com.mr.utils.LayResult;
import com.mr.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administer on 2019/5/8.
 */
@Service
public class CouponsServiceImpl implements CouponsService {

    @Autowired
    private CouponsMapper couponsMapper;

    /**
     * 增加
     *
     * @param coupons
     * @return
     */
    @Override
    public int insertCoupons(Coupons coupons) {
        return couponsMapper.insertCoupons(coupons);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteCoupons(Integer id) {
        return couponsMapper.deleteCoupons(id);
    }

    /**
     * 修改
     *
     * @param coupons
     * @return
     */
    @Override
    public int updateCoupons(Coupons coupons) {
        return couponsMapper.updateCoupons(coupons);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Coupons selectCouponsById(Integer id) {
        return couponsMapper.selectCouponsById(id);
    }

    /**
     * 调价查询
     *
     * @param coupons
     * @param page
     * @return
     */
    @Override
    public LayResult<Coupons> selectCouponsList(Coupons coupons, Page page) {
        if (page == null) page = new Page();
        PageHelper.startPage(page.getPage(), page.getLimit());
        List<Coupons> couponsList = couponsMapper.selectCouponsList(coupons);
        PageInfo<Coupons> pageInfo = new PageInfo<>(couponsList);
        LayResult<Coupons> layResult = new LayResult<>(0, "", pageInfo.getTotal(), pageInfo.getList(), null);
        return layResult;
    }
}
