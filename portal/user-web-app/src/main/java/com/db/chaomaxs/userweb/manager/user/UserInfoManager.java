package com.db.chaomaxs.userweb.manager.user;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.resourceservice.rpc.resource.facade.ResourceRpcFacade;
import com.db.chaomaxs.userservice.enums.sms.UserSmsSceneEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserInfoRpcFacade;
import com.db.chaomaxs.userweb.controller.user.dto.ForgetPasswordReqDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UpdatePasswordReqDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserInfoUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserUpdateMobileReqDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserInfoVO;
import com.db.chaomaxs.userweb.convert.user.UserInfoConvert;
import com.db.chaomaxs.userweb.service.sms.VerifySmsCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserInfoManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserInfoManager {

  @Autowired
  private UserInfoRpcFacade userInfoRpcFacade;

  @Autowired
  private ResourceRpcFacade resourceRpcFacade;

  @Autowired
  private VerifySmsCodeService verifySmsCodeService;


  /**
   * 更新密码
   *
   * @param forgetPasswordReqDTO
   * @param ip
   * @return
   */
  public boolean forgetPassword(ForgetPasswordReqDTO forgetPasswordReqDTO, String ip) {
    boolean hasSuccess = verifySmsCodeService
        .verifySmsCode(forgetPasswordReqDTO.getMobile(), forgetPasswordReqDTO.getCode(), ip,
            UserSmsSceneEnum.UPDATE_PASSWORD);
    if (hasSuccess) {
      ObjectRestResponse<Boolean> objectRestResponse = this.userInfoRpcFacade
          .setPassword(forgetPasswordReqDTO.getMobile(), forgetPasswordReqDTO.getPassword());
      objectRestResponse.checkError();
      return objectRestResponse.getData();
    }
    return false;
  }

  /**
   * 更新手机号码
   *
   * @param updateMobileReq
   * @param ip
   * @return
   */
  public boolean updateMobile(UserUpdateMobileReqDTO updateMobileReq, String ip) {
    boolean hasSuccess = verifySmsCodeService
        .verifySmsCode(updateMobileReq.getMobile(), updateMobileReq.getCode(), ip,
            UserSmsSceneEnum.UPDATE_MOBILE);
    if (hasSuccess) {
      final String username = BaseContextHandler.getUsername();
      ObjectRestResponse<Boolean> objectRestResponse = this.userInfoRpcFacade
          .updateMobile(username, updateMobileReq.getMobile());
      objectRestResponse.checkError();
      return objectRestResponse.getData();
    }
    return false;
  }

  /**
   * 设置密码
   *
   * @param password
   * @return
   */
  public boolean setPassword(String password) {
    ObjectRestResponse<Boolean> objectRestResponse = this.userInfoRpcFacade
        .setPassword(BaseContextHandler.getUsername(), password);
    objectRestResponse.checkError();
    return objectRestResponse.getData();
  }

  public boolean updatePassword(UpdatePasswordReqDTO updatePasswordReqDTO) {
    final String username = BaseContextHandler.getUsername();
    ObjectRestResponse<Boolean> objectRestResponse = this.userInfoRpcFacade
        .updatePassword(username, updatePasswordReqDTO.getOldPassword(),
            updatePasswordReqDTO.getPassword());
    objectRestResponse.checkError();
    return objectRestResponse.getData();
  }

  /**
   * 根据用户id查找个人资料
   *
   * @return
   */
  public UserInfoVO getUserInfoById() {
    ObjectRestResponse<UserPersonalInfoRespDTO> objectRestResponse = userInfoRpcFacade
        .getUserInfoById(Long.parseLong(BaseContextHandler.getUserID()));
    objectRestResponse.checkError();
    return  UserInfoConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 更新个人资料数据
   *
   * @param userInfoUpdateDTO 更新参数
   * @return
   */
  public int update(UserInfoUpdateDTO userInfoUpdateDTO) {
    UserInfoUpdateReqDTO reqDTO = UserInfoConvert.INSTANCE.convert(userInfoUpdateDTO);
    reqDTO.setId(Long.parseLong(BaseContextHandler.getUserID()));
    BaseResponse baseResponse = userInfoRpcFacade.update(reqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

}
