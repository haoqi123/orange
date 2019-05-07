package com.mr.utils;


import com.mr.commont.commodity.Commodity;
import com.mr.commont.commodity.GoodsTypeEntry;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administer on 2019/5/3.
 */
@Data
public class SearchResult implements Serializable{

    //总页数
    private Integer totalPage;
    //当前页
    private Integer currNum;
    //总条数
    private Long totalNum;
    /**
     * 类目
     */
    private Set<GoodsTypeEntry> goodsTypeSet;

    /**
     * 参数
     */
    private Map<String,Set<String>> parameterSet;

    /**
     * 商品集合
     */
    private List<Commodity> commoditieList;


}
