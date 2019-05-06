package com.mr.config;


import com.mr.commont.commodity.Commodity;
import com.mr.commont.commodity.GoodsTypeEntry;
import com.mr.utils.LayResult;
import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administer on 2019/5/3.
 */
@Data
public class SearchResult extends LayResult<Commodity> {

    /**
     * 类目
     */
    private Set<GoodsTypeEntry> goodsTypeSet;

    /**
     * 参数
     */
    private Map<String,Set<String>> parameterSet;


}
