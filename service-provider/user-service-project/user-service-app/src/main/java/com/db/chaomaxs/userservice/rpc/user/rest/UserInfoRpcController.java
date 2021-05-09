package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.UserInfoRpcImpl;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.api.UserInfoApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@RestController
public class UserInfoRpcController implements UserInfoApi {

  @Autowired
  private UserInfoRpcImpl userInfoRpc;

  @Override
  public BaseResponse save(@RequestBody UserInfoCreateReqDTO createReqDTO) {
    return userInfoRpc.save(createReqDTO);
  }

  @Override
  public ObjectRestResponse<UserInfoRespDTO> createUserIfAbsent(UserInfoCreateReqDTO createReqDTO) {
    return userInfoRpc.createUserIfAbsent(createReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody UserInfoUpdateReqDTO updateReqDTO) {
    return userInfoRpc.update(updateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return userInfoRpc.remove(id);
  }


  @Override
  public ObjectRestResponse<List<UserInfoRespDTO>> listUserInfos(
      @RequestBody UserInfoListQueryReqDTO listQuery) {
    return userInfoRpc.listUserInfos(listQuery);
  }

  @Override
  public TableResultResponse<UserInfoRespDTO> page(@RequestBody UserInfoPageReqDTO pageReqDTO) {
    return userInfoRpc.page(pageReqDTO);
  }

  @Override
  public ObjectRestResponse<UserInfoRespDTO> verifyPassword(String username, String password) {
    return userInfoRpc.verifyPassword(username, password);
  }

  @Override
  public ObjectRestResponse<Boolean> setPassword(String username, String password) {
    return userInfoRpc.setPassword(username, password);
  }

  @Override
  public ObjectRestResponse<Boolean> updateMobile(String username, String mobile) {
    return userInfoRpc.updateMobile(username, mobile);
  }

  @Override
  public ObjectRestResponse<Boolean> updatePassword(String username, String oldPassword,
      String password) {
    return userInfoRpc.updatePassword(username, oldPassword, password);
  }

  @Override
  public ObjectRestResponse<UserPersonalInfoRespDTO> getUserInfoById(@PathVariable("userId") Long userId) {
    return userInfoRpc.getUserInfoById(userId);
  }
}
