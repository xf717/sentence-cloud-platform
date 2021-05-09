package com.db.chaomaxs.userweb.controller.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.util.WebUtils;
import com.db.chaomaxs.common.framework.util.http.HttpUtil;
import com.db.chaomaxs.userweb.controller.user.dto.ForgetPasswordReqDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UpdatePasswordReqDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserInfoUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserUpdateMobileReqDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserInfoVO;
import com.db.chaomaxs.userweb.manager.user.UserInfoManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Api(value = "用户_帐号信息", description = "用户_帐号信息", tags = "用户_帐号信息")
@RestController
@RequestMapping("/rest/userInfo")
public class UserInfoController {

  @Autowired
  private UserInfoManager userInfoManager;


  /**
   * 更新密码
   *
   * @param forgetPassword
   * @return
   */
  @PutMapping("/forget-password")
  @ApiOperation(value = "忘记密码", produces = "application/json", nickname = "forgetPassword")
  public ObjectRestResponse<Boolean> forgetPassword(
      @Valid @RequestBody ForgetPasswordReqDTO forgetPassword) {
    final String ip = HttpUtil.getIp(WebUtils.getRequest());
    boolean hasSuccess = userInfoManager.forgetPassword(forgetPassword, ip);
    return ObjectRestResponse.success(hasSuccess);
  }

  @PutMapping("/update-mobile")
  @ApiOperation(value = "修改手机号码", produces = "application/json", nickname = "updateMobile")
  public ObjectRestResponse<Boolean> updateMobile(
      @Valid @RequestBody UserUpdateMobileReqDTO updateMobileReq) {
    final String ip = HttpUtil.getIp(WebUtils.getRequest());
    boolean hasSuccess = userInfoManager.updateMobile(updateMobileReq, ip);
    return ObjectRestResponse.success(hasSuccess);
  }

  @PutMapping("/set-password")
  @ApiOperation(value = "设置密码", produces = "application/json", nickname = "setPassword")
  @ApiImplicitParam(name = "password", dataType = "String", paramType = "query", required = true)
  public ObjectRestResponse<Boolean> setPassword(String password) {
    boolean hasSuccess = userInfoManager.setPassword(password);
    return ObjectRestResponse.success(hasSuccess);
  }

  @PutMapping("/update-password")
  @ApiOperation(value = "修改密码", produces = "application/json", nickname = "updatePassword")
  @ApiImplicitParam(name = "password", dataType = "String", paramType = "query", required = true)
  public ObjectRestResponse<Boolean> updatePassword(@RequestBody UpdatePasswordReqDTO updatePassword) {
    boolean hasSuccess = userInfoManager.updatePassword(updatePassword);
    return ObjectRestResponse.success(hasSuccess);
  }

  /**
   * 根据用户id查询个人资料
   *
   * @return
   * @author wst
   */
  @ApiOperation(value = "根据用户id查询个人资料", nickname = "get")
  @GetMapping("/get")
  public ObjectRestResponse<UserInfoVO> getUserInfoById() {
    return ObjectRestResponse.success(userInfoManager.getUserInfoById());
  }

  /**
   * 注册更新个人数据-更新
   * @author wst
   * @param updateDTO
   * @return
   */
  @ApiOperation(value = "更新个人资料", produces = "application/json", nickname = "update")
  @PutMapping("/update")
  public BaseResponse update(@Valid @RequestBody UserInfoUpdateDTO updateDTO) {
    userInfoManager.update(updateDTO);
    return BaseResponse.success("更新成功");
  }
}
