package com.sunda.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 老蹄子 on 2018/8/18 下午9:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T> {

    /** 错误码 */
    public static final Integer ERROR = -1;

    /** 特定错误码 */
    private Integer code;

    /** 错误信息 */
    private String message;

    /** 请求 url */
    private String url;

    /** 请求返回的数据 */
    private T data;
}
