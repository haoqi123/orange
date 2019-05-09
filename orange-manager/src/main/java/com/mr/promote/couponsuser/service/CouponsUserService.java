package com.mr.promote.couponsuser.service;

import com.mr.commont.promote.coupons.Coupons;
import com.mr.commont.promote.coupons.CouponsUser;
import com.mr.utils.LayResult;
import com.mr.utils.Page;

/**
 * Created by Administer on 2019/5/9.
 */
public interface CouponsUserService {
    /**
     * 条件查询
     */
    LayResult<CouponsUser> selectCouponsUserList(CouponsUser couponsUser, Page page);
}
