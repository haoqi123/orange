package com.mr.buy.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by FHJ on 2019/5/7.
 *购买页面前台接口
 */
@FeignClient(value = "ORANGE-SEARCH")
public interface BuyService {

    /*调用商品详细信息接口*/


}

