package com.mr.buy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by FHJ on 2019/5/7.
 *购买页面前台接口
 */
@FeignClient(value="ORANGE-ORDER")
public interface BuyService {
    /*调用商品详细信息接口*/
    @RequestMapping(value="/Abuy/selectById")
    String queryGoods(@RequestParam("id") Integer id);




}

