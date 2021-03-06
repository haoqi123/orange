package com.mr.controller;

import com.alibaba.fastjson.JSONObject;
import com.mr.commont.commodity.Commodity;
import com.mr.utils.SearchCommodityVO;
import com.mr.utils.SearchResult;
import com.mr.service.SearchServer;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @RequestMapping("searchDoc")
    public String searchName(@RequestParam("name") String name) throws IOException, SolrServerException {
        //不允许查空
        if (name.isEmpty())return null;

        SolrQuery query = new SolrQuery();
        query.setQuery("c_name:"+name);
        QueryResponse response = solrClient.query(query);
        List<Commodity> list = response.getBeans(Commodity.class);
        //如果为空
        if (list==null&&list.size()==0)return null;

        //System.out.println(list);
        List<Integer> goodsId = new ArrayList<>();
        List<Integer> typeId = new ArrayList<>();
        for (Commodity c:list) {
            goodsId.add(c.getGoodsSn());
            typeId.add(c.getGtId());
        }
        SearchResult searchResult = new SearchResult();
        searchResult.setGoodsTypeSet(searchServer.selectGoodsTypeIds(typeId));
        searchResult.setParameterSet(searchServer.selectParameterIds(goodsId));
        searchResult.setCommoditieList(list);

        String string = JSONObject.toJSONString(searchResult);
        System.err.println(string);
        return string;
    }

    @RequestMapping("selectById")
    public String selectById(@RequestParam("id") Integer id){
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        //查询商品参数
        Map<String, Set<String>> stringSetMap = searchServer.selectParameterIds(ids);
        //查询商品详情
        SearchCommodityVO searchCommodityVO = searchServer.selectById(id);
        searchCommodityVO.setParameterSet(stringSetMap);
        String string = JSONObject.toJSONString(searchCommodityVO);
        return string;
    }
}
