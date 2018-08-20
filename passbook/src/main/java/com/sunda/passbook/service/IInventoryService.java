package com.sunda.passbook.service;

import com.sunda.passbook.vo.Response;

/**
 * 获取库存信息: 只返回用户没有领取的
 * Created by 老蹄子 on 2018/8/19 下午10:13
 */
public interface IInventoryService {

    /**
     * 获取库存信息
     * @param userId 用户 id
     * @return {@link Response}
     * */
    Response getInventoryInfo(Long userId) throws Exception;
}
