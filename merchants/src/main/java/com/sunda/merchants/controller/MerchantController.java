package com.sunda.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.sunda.merchants.service.IMerchantsService;
import com.sunda.merchants.vo.CreateMerchantsRequest;
import com.sunda.merchants.vo.PassTemplate;
import com.sunda.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 老蹄子 on 2018/8/16 下午3:28
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantController {

    @Autowired
    private IMerchantsService merchantsService;

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {

        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        return merchantsService.createMerchants(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id) {

        log.info("BuildMerchantsInfo: {}", id);
        return merchantsService.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate) {

        log.info("DropPassTemplate: {}", passTemplate);
        return merchantsService.dropPassTemplate(passTemplate);
    }
}
