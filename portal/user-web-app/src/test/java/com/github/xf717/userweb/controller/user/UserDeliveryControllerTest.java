package com.github.xf717.userweb.controller.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userweb.controller.user.dto.UserDeliveryPageDTO;
import com.github.xf717.userweb.controller.user.vo.UserPositionCollectVO;
import com.github.xf717.userweb.manager.user.UserDeliveryManager;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class UserDeliveryControllerTest extends TestCase {

  @Autowired
  private UserDeliveryManager userDeliveryManager;
  @Test
  public void testPage() {
    UserDeliveryPageDTO dto = new UserDeliveryPageDTO();
    dto.setPageNo(1);
    dto.setPageSize(10);
    TableResultResponse<UserPositionCollectVO> userPositionCollectVOTableResultResponse = userDeliveryManager
        .pageUserDelivery(dto);
    System.out.println(userPositionCollectVOTableResultResponse);
  }
}
