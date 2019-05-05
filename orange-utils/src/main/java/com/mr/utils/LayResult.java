package com.mr.utils;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by haoqi on 2019/4/8.
 */
@Data
@ToString
public class LayResult<E> {
    private Integer code;
    private String msg;
    private Long count;
    private List<E> data;
    private Object object;

    public LayResult() {
    }

    public LayResult(Integer code, String msg, Long count, List<E> data, Object object) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
        this.object = object;
    }

    //成功返回
    public static LayResult success(String msg) {
        return new LayResult(200, msg, null, null,null);
    }

    //成功返回,带数据
    public static LayResult success(String msg,Object obj) {
        return new LayResult(200, msg, null, null,obj);
    }

    //失败返回
    public static LayResult error(Integer code, String msg) {
        return new LayResult(code, msg, null, null,null);
    }
}
