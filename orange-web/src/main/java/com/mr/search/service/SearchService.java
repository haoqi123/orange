package com.mr.search.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by Administer on 2019/5/6.
 */
@FeignClient(value = "ORANGE-SEARCH")
public interface SearchService {

    @RequestMapping(value = "/search/searchDoc",method = RequestMethod.GET)
    String SearchName(@RequestParam("name")String name);

    @RequestMapping(value = "/search/selectById",method = RequestMethod.GET)
    String SelectId(@RequestParam("id")Integer id);
}