package com.sunda.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 老蹄子 on 2018/8/15 下午9:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    /** 错误码, 正确返回 0 */
    private Integer errorCode = 0;

    /** 错误信息, 正确返回空字符串 */
    private String errorMsg = "";

    /** 返回值对象 */
    private Object data;


    public Response(Object data) {
        this.data = data;
    }
}
