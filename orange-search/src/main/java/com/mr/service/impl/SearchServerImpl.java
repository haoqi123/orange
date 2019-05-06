package com.mr.service.impl;

import com.mr.commont.commodity.GoodsTypeEntry;
import com.mr.commont.commodity.Parameter;
import com.mr.dao.SearchMapper;
import com.mr.service.SearchServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administer on 2019/5/5.
 */
@Service
public class SearchServerImpl implements SearchServer {

    @Autowired
    private SearchMapper mapper;

    @Override
    public Set<GoodsTypeEntry> selectGoodsTypeIds(List<Integer> ids) {
        Set<GoodsTypeEntry> set = new HashSet<>();
        List<GoodsTypeEntry> goodsTypeEntries = mapper.selectGoodsTypeIds(ids);
        for (GoodsTypeEntry g : goodsTypeEntries) set.add(g);
        return set;
    }

    @Override
    public Map<String,Set<String>> selectParameterIds(List<Integer> ids) {
        Map<String,Set<String>> map = new HashMap<>();

        List<Parameter> parameters = mapper.selectParameterIds(ids);
        if(parameters==null&&parameters.size()==0){
            return null;
        }
        Set<String> strings;
        for (Parameter p:parameters) {
            strings = map.get(p.getPName());
            strings.add(p.getPValue());
            map.put(p.getPName(),strings);
        }
        return map;
    }


}
