package com.mr.dao;

import com.mr.commont.commodity.GoodsTypeEntry;
import com.mr.commont.commodity.Parameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administer on 2019/5/5.
 */
@Component
public interface SearchMapper {

    /**
     * 查询商品类型名
     * @param ids
     * @return
     */
    List<GoodsTypeEntry> selectGoodsTypeIds(@Param("ids") List<Integer> ids);

    /**
     * 查询商品参数
     * @param ids
     * @return
     */
    List<Parameter> selectParameterIds(@Param("ids") List<Integer> ids);
}
