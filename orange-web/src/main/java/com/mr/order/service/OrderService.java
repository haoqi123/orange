package com.mr.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by shangpengyu on 2019/5/5.
 */
@FeignClient(value="ORANGE-ORDER")
public interface OrderService {
    
    @RequestMapping("test")
    String test(@RequestParam("name") String name);

}
