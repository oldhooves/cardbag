package com.sunda.passbook.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 老蹄子 on 2018/8/17 下午1:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogObject {

    /** 日志动作类型 */
    private String action;

    /** 用户 id */
    private Long userId;

    /** 当前时间戳 */
    private Long timestamp;

    /** 客户端 ip 地址 */
    private String remoteIp;

    /** 日志信息 */
    private Object info = null;
}
