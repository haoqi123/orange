package com.mr.commont.promote.coupons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administer on 2019/5/9.
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CouponsUser {
    private Integer userQuanId;//主键
    private Integer userId;//用户Id
    private Integer quanId;//优惠券Id
    private Integer quanStatus;//使用状态
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp addTime;//领取时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp updateTime;//使用时间
}
