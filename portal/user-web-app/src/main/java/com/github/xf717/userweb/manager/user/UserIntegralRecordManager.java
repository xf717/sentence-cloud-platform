package com.github.xf717.userweb.manager.user;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.userservice.rpc.user.facade.UserIntegralRecordRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserIntegralRecordManager
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserIntegralRecordManager {

  @Autowired
  private UserIntegralRecordRpcFacade userIntegralRecordRpcFacade;


  /**
   * 根据用户id签到
   *
   * @return
   */
  public int sign() {
    BaseResponse baseResponse = userIntegralRecordRpcFacade
        .sign(Long.parseLong(BaseContextHandler.getUserID()));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


}
