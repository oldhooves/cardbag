package com.sunda.passbook.controller;

import com.sunda.passbook.log.LogConstants;
import com.sunda.passbook.log.LogGenerator;
import com.sunda.passbook.service.IUserService;
import com.sunda.passbook.vo.Response;
import com.sunda.passbook.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 老蹄子 on 2018/8/20 下午10:28
 */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class CreateUserController {

    /** 创建用户服务 */
    private final IUserService userService;

    /** HttpServletRequest */
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public CreateUserController(IUserService userService,
                                HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 创建用户
     * @param user {@link User}
     * @return {@link Response}
     * */
    @ResponseBody
    @PostMapping("/createuser")
    Response createUser(@RequestBody User user) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                -1L,
                LogConstants.ActionName.CREATE_USER,
                user
        );
        return userService.createUser(user);
    }
}
