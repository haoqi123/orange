package com.mr.promote.couponsuser.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mr.commont.promote.coupons.Coupons;
import com.mr.commont.promote.coupons.CouponsUser;
import com.mr.promote.couponsuser.mapper.CouponsUserMapper;
import com.mr.promote.couponsuser.service.CouponsUserService;
import com.mr.utils.LayResult;
import com.mr.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administer on 2019/5/9.
 */
@Service
public class CouponsUserServiceImpl implements CouponsUserService{
    @Autowired
    private CouponsUserMapper mapper;

    /**
     * 条件查询
     * @param couponsUser
     * @param page
     * @return
     */
    @Override
    public LayResult<CouponsUser> selectCouponsUserList(CouponsUser couponsUser, Page page) {
        if (page==null) page = new Page();
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<CouponsUser> list = mapper.selectCouponsUserList(couponsUser);
        PageInfo<CouponsUser> info = new PageInfo<>(list);
        LayResult<CouponsUser> layResult = new LayResult<>(0, "", info.getTotal(), info.getList(), null);
        return layResult;
    }
}
