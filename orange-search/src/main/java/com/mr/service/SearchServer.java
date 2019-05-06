package com.mr.service;

import com.mr.commont.commodity.GoodsTypeEntry;
import com.mr.commont.commodity.Parameter;
import org.apache.ibatis.annotations.Param;

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
    Set<GoodsTypeEntry> selectGoodsTypeIds(@Param("ids") List<Integer> ids);

    /**
     * 查询商品参数
     * @param ids
     * @return
     */
    Map<String,Set<String>> selectParameterIds(@Param("ids") List<Integer> ids);
}
