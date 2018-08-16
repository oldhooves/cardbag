package com.sunda.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.sunda.merchants.constant.Constants;
import com.sunda.merchants.constant.ErrorCode;
import com.sunda.merchants.dao.MerchantsDao;
import com.sunda.merchants.entity.Merchants;
import com.sunda.merchants.service.IMerchantsService;
import com.sunda.merchants.vo.CreateMerchantsRequest;
import com.sunda.merchants.vo.CreateMerchantsResponse;
import com.sunda.merchants.vo.PassTemplate;
import com.sunda.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 老蹄子 on 2018/8/15 下午10:06
 */
@Slf4j
@Service
public class MerchantsServiceImpl implements IMerchantsService {

    @Autowired
    private MerchantsDao merchantsDao;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }

        response.setData(merchantsResponse);

        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {

        Response response = new Response();

        Merchants merchants = merchantsDao.findById(id);
        if (null == merchants) {
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }

        response.setData(merchants);

        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        Response response = new Response();
        ErrorCode errorCode = template.validate(merchantsDao);

        if (errorCode != ErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            String passTemplate = JSON.toJSONString(template);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    passTemplate
            );
            log.info("DropPassTemplates: {}", passTemplate);
        }

        return response;
    }

}
