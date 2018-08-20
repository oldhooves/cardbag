package com.sunda.passbook.service;

import com.sunda.passbook.vo.Pass;
import com.sunda.passbook.vo.Response;

/**
 * Created by 老蹄子 on 2018/8/19 下午10:27
 */
public interface IUserPassService {

    /**
     * 获取用户个人优惠券信息, 即我的优惠券功能实现
     * @param userId 用户 id
     * @return {@link Response}
     * */
    Response getUserPassInfo(Long userId) throws Exception;

    /**
     * 获取用户已经消费了的优惠券, 即已使用优惠券功能实现
     * @param userId 用户 id
     * @return {@link Response}
     * */
    Response getUserUsedPassInfo(Long userId) throws Exception;

    /**
     * 获取用户所有的优惠券
     * @param userId 用户 id
     * @return {@link Response}
     * */
    Response getUserAllPassInfo(Long userId) throws Exception;

    /**
     * 用户使用优惠券
     * @param pass {@link Pass}
     * @return {@link Response}
     * */
    Response userUsePass(Pass pass);
}


