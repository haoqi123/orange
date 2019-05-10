package com.mr.buy.controller;

import com.alibaba.fastjson.JSONObject;
import com.mr.buy.service.BuyService;
import com.mr.commont.buy.Address;
import com.mr.commont.buy.BuyGoods;
import com.mr.commont.buy.Coupopn;
import com.mr.utils.BuyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by FHJ on 2019/5/6.
 * 购买前台项目接口
 */
@RestController
@RequestMapping("Abuy")
public class BuyController {

    @Autowired
    private BuyService buyService;


    @RequestMapping("selectById")
    @ResponseBody
    public String selectByIdGoods(@RequestParam("id") Integer id){

        //查询商品的全部信息（根据id）
        List<BuyGoods>buyGoodsList = buyService.selectGoods(id);
        System.out.println(buyGoodsList);
        //查询收货地址
        List<Coupopn>coupopnsList =buyService.selectCoupon(id);
        System.out.println(coupopnsList);
        //查询物流
        Set<Address> addressSet = buyService.selectAddress(id);
        System.out.println(addressSet);
        BuyResult buyResult = new BuyResult();
        buyResult.setAddressSet(addressSet);
        buyResult.setBuyGoodsList(buyGoodsList);
        buyResult.setCoupopnsList(coupopnsList);
        String s = JSONObject.toJSONString(buyResult);
        System.out.println(s);
        return s;
    }



}
