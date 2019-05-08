package com.mr.commont.promote.kill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Administer on 2019/5/8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SecKill {
    private Integer seckillId;//'编号',
    private Integer goodsSn; //'商品主键',
    private String  name;   //'活动名称',
    private Date createTime; //'创建时间',
    private Date  startTime; // '活动开始时间',
    private Date  endTime;   //'结束时间',
    private Integer number;  // '数量',
}
