package com.mr.commont.search;

import lombok.Data;
import lombok.ToString;

/**
 * Created by haoqi on 2019/5/4.
 * 商品参数表
 */
@Data
@ToString
public class ParameterEntry {

    //表主键
    private Integer pId;

    //商品编号
    private Integer cGoodsSn;

    //商品参数名称
    private String pName;

    //商品参数值
    private String pValue;
}
