package com.sunda.merchants.service.impl;

import com.sunda.merchants.service.IMerchantsService;
import com.sunda.merchants.vo.CreateMerchantsRequest;
import com.sunda.merchants.vo.PassTemplate;
import com.sunda.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by 老蹄子 on 2018/8/15 下午10:06
 */
@Slf4j
@Service
public class MerchantsServiceImpl implements IMerchantsService {

    @Override
    public Response createMerchants(CreateMerchantsRequest request) {
        return null;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {
        return null;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        return null;
    }
}
