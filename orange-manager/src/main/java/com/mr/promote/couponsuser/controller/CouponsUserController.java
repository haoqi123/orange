package com.mr.promote.couponsuser.controller;

import com.mr.commont.promote.coupons.CouponsUser;
import com.mr.promote.couponsuser.service.CouponsUserService;
import com.mr.utils.LayResult;
import com.mr.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administer on 2019/5/9.
 */
@RestController
@RequestMapping("CouponsUserController")
public class CouponsUserController {

    @Autowired
    private CouponsUserService service;

    /**
     * 条件查询
     * @param couponsUser
     * @param page
     * @return
     */
    @RequestMapping("selectCouponsUserList")
    public LayResult<CouponsUser> selectCouponsUserList(CouponsUser couponsUser, Page page) {
        return service.selectCouponsUserList(couponsUser,page);
    }

}
