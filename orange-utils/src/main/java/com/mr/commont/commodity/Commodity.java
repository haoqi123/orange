package com.mr.commont.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 商品管理表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commodity {
    //主键
    private Integer tCommodityId;
    //类目ID
    private Integer gtId;
    //商品编号
    private Integer cGoodsSn;
    //商品名称
    private String cName;
    //专柜价格
    private Double cCounterPrice;
    //当前价格
    private Double cRetailPrice;
    //  1 新品 2非新品 是否新品
    private Integer cIsHot;
    // 1 热品  2非热品   是否热品
    private Integer cIsNew;
    //是否在售 1在售 2非在售
    private Integer cIsOnSale;
    //关键字
    private String cKeywords;
    //商品单位
    private Integer cUnit;
    //商品介绍
    private String cBrief;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cAddTime;
    public String getcAddTimes(){
        if(cAddTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(cAddTime);
        }
        return "";
    }
    //修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cUpdateTime;
    public String getcUpdateTimes(){
        if(cUpdateTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(cUpdateTime);
        }
        return "";
    }
    //规格
    private String cSpec;
    //商品库存数量 默认值 0
    private Integer cNumber;
}
