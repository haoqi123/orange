package com.mr.search.controller;

import com.alibaba.fastjson.JSONObject;
import com.mr.search.service.SearchService;
import com.mr.utils.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



/**
 * Created by Administer on 2019/5/6.
 */
@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService service;

    @RequestMapping(value = "search",method= RequestMethod.GET)
    public ModelAndView search(@RequestParam("index_none_header_sysc") String name){
        String s = service.SearchName(name);
        SearchResult searchResult = JSONObject.parseObject(s, SearchResult.class);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/search/search");
        modelAndView.addObject("result",searchResult);
        return modelAndView;
    }

}
