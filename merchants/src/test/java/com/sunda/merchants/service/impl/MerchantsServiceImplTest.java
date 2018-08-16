package com.sunda.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.sunda.merchants.service.IMerchantsService;
import com.sunda.merchants.vo.CreateMerchantsRequest;
import com.sunda.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by 老蹄子 on 2018/8/16 上午9:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantsServiceImplTest {

    @Autowired
    private IMerchantsService merchantsService;

    @Test
    public void testCreateMerchantService() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("laotizi");
        request.setLogoUrl("www.laotizi.com");
        request.setBusinessLicenseUrl("www.laotizi.com");
        request.setPhone("1234567890");
        request.setAddress("上海");

        System.out.println(JSON.toJSONString(merchantsService.createMerchants(request)));
    }

    @Test
    public void testBuildMerchantsInfoById() {

        System.out.println(JSON.toJSONString(merchantsService.buildMerchantsInfoById(17)));
    }

    @Test
    public void testDropPassTemplate() {

        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(18);
        passTemplate.setTitle("laotizia");
        passTemplate.setSummary("laotizai");
        passTemplate.setDesc("laotizi1");
        passTemplate.setLimit(100002L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(DateUtils.addDays(new Date(), -10));
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(
                merchantsService.dropPassTemplate(passTemplate)
        ));
    }

}