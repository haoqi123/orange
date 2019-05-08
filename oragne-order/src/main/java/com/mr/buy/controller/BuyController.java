package com.mr.buy.controller;

import com.mr.buy.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by FHJ on 2019/5/6.
 * 购买前台项目接口
 */
@RestController
@RequestMapping("Abuy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    /*查询商品的全部信息和优惠劵*/
    /*public List queryGoods(){
        return
    }*/

    /*查询收货地址*/
   // public
    /*查询物流*/



}
