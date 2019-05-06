package com.mr.commont.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 商品参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parameter {
    //主键
    private Integer pId;

    //商品编号
    private Integer cGoodsSn;

    //商品参数名称
    private String pName;

    //商品参数值
    private String pValue;
}
