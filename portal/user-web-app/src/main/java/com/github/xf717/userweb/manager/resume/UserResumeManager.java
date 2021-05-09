package com.github.xf717.userweb.manager.resume;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.resourceservice.rpc.resource.facade.ResourceRpcFacade;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserResumeRpcFacade;
import com.github.xf717.userweb.controller.resume.dto.UserResumeUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserResumeVO;
import com.github.xf717.userweb.convert.resume.UserResumeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserResumeManager
 *
 * @author wst
 * @date 2021-03-29 13:08:13
 */
@Service
@Validated
public class UserResumeManager {

  @Autowired
  private UserResumeRpcFacade userResumeRpcFacade;

  @Autowired
  private ResourceRpcFacade resourceRpcFacade;



  /**
   * 更新数据
   *
   * @param userResumeUpdateDTO 更新参数
   * @return
   */
  public int update(UserResumeUpdateDTO userResumeUpdateDTO) {
    BaseResponse baseResponse = userResumeRpcFacade
        .update(UserResumeConvert.INSTANCE.convert(userResumeUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }


  /**
   * 根据用户Id查找
   * @return
   */
  public UserResumeVO getUserResumeByUserId() {
    Long userId = Long.parseLong(BaseContextHandler.getUserID());
    ObjectRestResponse<UserResumeRespDTO> objectRestResponse = userResumeRpcFacade
        .getUserResumeById(userId);
    objectRestResponse.checkError();
    return UserResumeConvert.INSTANCE.convert(objectRestResponse.getData());
  }

}
