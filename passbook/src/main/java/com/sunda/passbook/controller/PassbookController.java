package com.sunda.passbook.controller;

import com.sunda.passbook.log.LogConstants;
import com.sunda.passbook.log.LogGenerator;
import com.sunda.passbook.service.IFeedbackService;
import com.sunda.passbook.service.IGainPassTemplateService;
import com.sunda.passbook.service.IInventoryService;
import com.sunda.passbook.service.IUserPassService;
import com.sunda.passbook.vo.Feedback;
import com.sunda.passbook.vo.GainPassTemplateRequest;
import com.sunda.passbook.vo.Pass;
import com.sunda.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 老蹄子 on 2018/8/20 下午8:35
 */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class PassbookController {

    /** 用户优惠券服务 */
    private final IUserPassService userPassService;

    /** 优惠券库存服务 */
    private final IInventoryService inventoryService;

    /** 领取优惠券服务 */
    private final IGainPassTemplateService gainPassTemplateService;

    /** 反馈服务 */
    private final IFeedbackService feedbackService;

    /** HttpServletRequest */
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public PassbookController(IUserPassService userPassService,
                              IInventoryService inventoryService,
                              IGainPassTemplateService gainPassTemplateService,
                              IFeedbackService feedbackService,
                              HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService;
        this.inventoryService = inventoryService;
        this.gainPassTemplateService = gainPassTemplateService;
        this.feedbackService = feedbackService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 获取用户个人的优惠券信息
     * @param userId 用户 id
     * @return {@link Response}
     * */
    @ResponseBody
    @GetMapping("/userpassinfo")
    public Response userPassInfo(Long userId) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_PASS_INFO,
                null
        );
        return userPassService.getUserPassInfo(userId);
    }

    /**
     * 获取用户使用了的优惠券信息
     * @param userId 用户 id
     * @return {@link Response}
     * */
    @ResponseBody
    @GetMapping("userusedpassinfo")
    public Response userUsedPassInfo(Long userId) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                userId, LogConstants.ActionName.USER_USED_PASS_INFO,
                null
        );
        return userPassService.getUserUsedPassInfo(userId);
    }

    /**
     * 用户使用优惠券
     * @param pass {@link Pass}
     * @return {@link Response}
     * */
    @ResponseBody
    @PostMapping("/userusepass")
    public Response userUsePass(@RequestBody Pass pass) {

        LogGenerator.genLog(
                httpServletRequest,
                pass.getUserId(),
                LogConstants.ActionName.USER_USE_PASS,
                pass
        );
        return userPassService.userUsePass(pass);
    }

    /**
     * 获取库存信息
     * @param userId 用户 id
     * @return {@link Response}
     * */
    @ResponseBody
    @GetMapping("/inventoryinfo")
    public Response inventoryInfo(Long userId) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.INVENTORY_INFO,
                null
        );
        return inventoryService.getInventoryInfo(userId);
    }

    /**
     * 用户领取优惠券
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * */
    @ResponseBody
    @PostMapping("/gainpasstemplate")
    public Response gainPassTemplate(@RequestBody GainPassTemplateRequest request)
            throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                request.getUserId(),
                LogConstants.ActionName.GAIN_PASS_TEMPLATE,
                request
        );
        return gainPassTemplateService.gainPassTemplate(request);
    }

    /**
     * 用户创建评论
     * @param feedback {@link Feedback}
     * @return {@link Response}
     * */
    @ResponseBody
    @PostMapping("/createfeedback")
    public Response createFeedback(@RequestBody Feedback feedback) {

        LogGenerator.genLog(
                httpServletRequest,
                feedback.getUserId(),
                LogConstants.ActionName.CREATE_FEEDBACK,
                feedback
        );
        return feedbackService.createFeedback(feedback);
    }

    /**
     * 用户获取评论信息
     * @param userId 用户 id
     * @return {@link Response}
     * */
    @ResponseBody
    @GetMapping("/getfeedback")
    public Response getFeedback(Long userId) {

        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.GET_FEEDBACK,
                null
        );
        return feedbackService.getFeedback(userId);
    }

    /**
     * 异常演示接口
     * @return {@link Response}
     * */
    @ResponseBody
    @GetMapping("/exception")
    Response exception() throws Exception {
        throw new Exception("Welcome");
    }
}
