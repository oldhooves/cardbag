package com.sunda.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户领取优惠券的请求对象
 * Created by 老蹄子 on 2018/8/19 下午9:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainPassTemplateRequest {

    /** 用户 id */
    private Long userId;

    /** PassTemplate 对象 */
    private PassTemplate passTemplate;
}
