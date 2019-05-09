package com.mr.commont.buy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by FHJ on 2019/5/8.
 * 从数据库查询的商品详情和优惠劵（以后可以直接从商品详情页面获取，不再查询数据库）
 */
@Data
@AllArgsConstructor
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor
//使用后创建一个无参构造函数
@ToString
public class BuyGoods {

    //商品主键
    private String commodityId;

    //类目id
    private Integer gtId;

    //商品编号
    private Integer goodsSn;

    //商品描述
    private String goodsInt;

    //商品价格
    private Double goodsMoney;

    //配送方式(0:包邮，1：不包邮)
    //private Integer baoyu;

}
