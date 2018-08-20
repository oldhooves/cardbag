package com.sunda.passbook.service;

import com.sunda.passbook.vo.GainPassTemplateRequest;
import com.sunda.passbook.vo.Response;

/**
 * 用户领取优惠券功能实现
 * Created by 老蹄子 on 2018/8/19 下午10:15
 */
public interface IGainPassTemplateService {

    /**
     * 用户领取优惠券
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}
