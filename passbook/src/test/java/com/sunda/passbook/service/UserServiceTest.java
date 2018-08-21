package com.sunda.passbook.service;

import com.alibaba.fastjson.JSON;
import com.sunda.passbook.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 老蹄子 on 2018/8/21 下午12:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testCreateUser() throws Exception {

        User user = new User();
        user.setBaseInfo(
                new User.BaseInfo("sunda", 10, "m")
        );
        user.setOtherInfo(
                new User.OtherInfo("123456", "北京市朝阳区")
        );

        System.out.println(JSON.toJSONString(userService.createUser(user)));
    }
}
