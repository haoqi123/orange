package com.mr.commont.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;

/**
 * 商品参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parameter {
    //主键
    @Field("id")
    private Integer pId;

    //商品编号
    @Field("c_goods_sn")
    private Integer cGoodsSn;

    //商品参数名称
    @Field("p_name")
    private String pName;

    //商品参数值
    @Field("p_value")
    private String pValue;
}
