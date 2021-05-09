package com.github.xf717.userweb.manager.user.interview;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;

/**
 * @author momo
 * @date 2021-04-08 09:35
 */
public interface UserInterview {

  /**
   * 用户面试表更新状态
   *
   * @param userInterviewUpdateReqDTO
   * @return
   */
  BaseResponse updateUserInterviewState(UserInterviewUpdateReqDTO userInterviewUpdateReqDTO);

  /**
   * 企业面试表更新状态
   *
   * @param companyUserInterviewUpdateStateReqDTO
   * @return
   */
  BaseResponse updateCompanyUserInterviewState(
      CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO);
}
