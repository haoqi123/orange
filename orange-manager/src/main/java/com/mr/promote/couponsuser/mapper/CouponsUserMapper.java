package com.mr.promote.couponsuser.mapper;

import com.mr.commont.promote.coupons.CouponsUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administer on 2019/5/9.
 */
@Mapper
@Component
public interface CouponsUserMapper {

    /**
     * 条件查询
     * @return
     */
   List<CouponsUser> selectCouponsUserList(CouponsUser couponsUser);

    /**
     * 增加
     * @param couponsUser
     * @return
     */
   int addCouponsUser(CouponsUser couponsUser);

    /**
     * 修改
     * @param couponsUser
     * @return
     */
   int updateCouponsUser(CouponsUser couponsUser);
}
