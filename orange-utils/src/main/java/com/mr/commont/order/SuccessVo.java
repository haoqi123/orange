package com.mr.commont.order;

import lombok.Data;

/**
 * Created by shangpengyu on 2019/5/8.
 */
@Data
public class SuccessVo {

    //收货人Id
    private String userName;

    //付款金额
    private String orderMoney;

    //电话
    private String orderPhone;

    //地址
    private String orderDz;
}
