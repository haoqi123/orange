package com.mr.controller;

import com.mr.commont.commodity.Commodity;
import com.mr.config.SearchResult;
import com.mr.service.SearchServer;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administer on 2019/4/30.
 */
@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchServer searchServer;

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
    @RequestMapping("search")
    public SearchResult searchName(String name) throws IOException, SolrServerException {
        //不允许查空
        if (name.isEmpty())return null;

        SolrQuery query = new SolrQuery();
        query.setQuery("c_name:"+name);
        QueryResponse response = solrClient.query(query);
        List<Commodity> list = response.getBeans(Commodity.class);
        //如果为空
        if (list==null&&list.size()==0)return null;

        //System.out.println(list);
        List<Integer> goodsId = null;
        List<Integer> typeId = null;
        for (Commodity c:list) {
            goodsId.add(c.getCGoodsSn());
            typeId.add(c.getGtId());
        }
        SearchResult searchResult = new SearchResult();
        searchResult.setGoodsTypeSet(searchServer.selectGoodsTypeIds(typeId));
        searchResult.setParameterSet(searchServer.selectParameterIds(goodsId));
        searchResult.setData(list);
        return searchResult;
    }
}
