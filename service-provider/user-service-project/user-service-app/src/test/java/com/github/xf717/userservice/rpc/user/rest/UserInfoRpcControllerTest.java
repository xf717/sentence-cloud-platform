package com.github.xf717.userservice.rpc.user.rest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.github.xf717.userservice.rpc.user.facade.UserInfoRpcFacade;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoRpcControllerTest {
  @Autowired
  private UserInfoRpcFacade userInfoRpcFacade;
  @Test
  public void getUserInfoById() {

    String s = 2012 + String.valueOf(9);
    DateTime workTotal = DateUtil
        .parse(s, "yyyyMM");
    int age = DateUtil.age(workTotal, new Date());
    System.out.println(age);
  }
}
