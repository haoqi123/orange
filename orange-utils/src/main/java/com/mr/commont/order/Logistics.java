package com.mr.commont.order;

import lombok.Data;

/**
 * Created by shangpengyu on 2019/5/6.
 */
@Data
public class Logistics {

    //物流主键
    private Integer logiId;

    //订单编号
    private Integer orderNo;

    //物流名称
    private String logiName;

    //物流单号
    private String logiNo;

}
