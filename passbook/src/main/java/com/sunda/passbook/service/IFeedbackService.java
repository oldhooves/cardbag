package com.sunda.passbook.service;

import com.sunda.passbook.vo.Feedback;
import com.sunda.passbook.vo.Response;

/**
 * Created by 老蹄子 on 2018/8/19 下午9:20
 */
public interface IFeedbackService {

    /**
     * 创建评论
     * @param feedback {@link Feedback}
     * @return {@link Response}
     * */
    Response createFeedback(Feedback feedback);

    /**
     * 获取用户评论
     * @param userId 用户 id
     * @return {@link Response}
     * */
    Response getFeedback(Long userId);
}
