package com.mr.service;

import com.mr.commont.commodity.GoodsTypeEntry;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administer on 2019/5/5.
 */
public interface SearchServer {


    /**
     * 查询商品类型名
     * @param ids
     * @return
     */
    Set<GoodsTypeEntry> selectGoodsTypeIds(List<Integer> ids);

    /**
     * 查询商品参数
     * @param ids
     * @return
     */
    Map<String,Set<String>> selectParameterIds(List<Integer> ids);
}
