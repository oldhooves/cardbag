package com.sunda.merchants.service;

import com.sunda.merchants.vo.CreateMerchantsRequest;
import com.sunda.merchants.vo.PassTemplate;
import com.sunda.merchants.vo.Response;

/**
 * Created by 老蹄子 on 2018/8/15 下午9:53
 */
public interface IMerchantsService {

    /**
     * 创建商户服务
     * @param request {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     * */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * 根据 id 构造商户信息
     * @param id 商户 id
     * @return {@link Response}
     * */
    Response buildMerchantsInfoById(Integer id);

    /**
     * 投放优惠券
     * @param template {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     * */
    Response dropPassTemplate(PassTemplate template);
}
