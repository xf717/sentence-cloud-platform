package com.db.chaomaxs.userweb.controller.user;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userweb.controller.user.dto.UserPositionCollectPageDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserPositionCollectVO;
import com.db.chaomaxs.userweb.manager.user.UserPositionCollectManager;
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
public class UserPositionCollectControllerTest extends TestCase {

  @Autowired
  private UserPositionCollectManager userPositionCollectManager;
  @Test
  public void page() {

    UserPositionCollectPageDTO dto = new UserPositionCollectPageDTO();
    dto.setPageNo(1);
    dto.setPageSize(10);
    TableResultResponse<UserPositionCollectVO> userPositionCollectVOTableResultResponse = userPositionCollectManager
        .pageUserPositionCollect(dto);
    System.out.println(userPositionCollectVOTableResultResponse);
  }
}