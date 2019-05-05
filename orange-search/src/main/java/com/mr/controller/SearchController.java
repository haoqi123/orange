package com.mr.controller;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administer on 2019/4/30.
 */
@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SolrClient solrClient;

    /**
     * 根据id查询索引
     * @return
     * @throws Exception
    @RequestMapping("getById")
    public String getById() throws Exception {
        SolrDocument document = solrClient.getById("1");
        System.out.println(document);
        return document.toString();
    }*/

    public void searchName(String name){

    }
}
