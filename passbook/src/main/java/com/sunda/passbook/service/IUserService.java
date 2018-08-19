package com.sunda.passbook.service;

import com.sunda.passbook.vo.Response;
import com.sunda.passbook.vo.User;

/**
 * Created by 老蹄子 on 2018/8/19 下午8:17
 */
public interface IUserService {

    /**
     * 创建用户
     * @param user {@link User}
     * @return {@link Response}
     * */
    Response createUser(User user) throws Exception;
}
