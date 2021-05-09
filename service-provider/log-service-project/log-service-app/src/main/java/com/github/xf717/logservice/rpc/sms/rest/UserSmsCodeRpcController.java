package com.github.xf717.logservice.rpc.sms.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.logservice.rpc.sms.UserSmsCodeRpcImpl;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeCreateReqDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeListQueryReqDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodePageReqDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeUpdateReqDTO;
import com.github.xf717.logservice.rpc.sms.facade.api.UserSmsCodeApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户短信验证码表
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@RestController
public class UserSmsCodeRpcController implements UserSmsCodeApi {

  @Autowired
  private UserSmsCodeRpcImpl userSmsCodeRpc;

  @Override
  public BaseResponse save(@RequestBody UserSmsCodeCreateReqDTO createReqDTO) {
    return userSmsCodeRpc.save(createReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody UserSmsCodeUpdateReqDTO updateReqDTO) {
    return userSmsCodeRpc.update(updateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return userSmsCodeRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<UserSmsCodeRespDTO> getUserSmsCodeById(@PathVariable("id") Long id) {
    return userSmsCodeRpc.getUserSmsCodeById(id);
  }

  @Override
  public ObjectRestResponse<List<UserSmsCodeRespDTO>> listUserSmsCodes(
      @RequestBody UserSmsCodeListQueryReqDTO listQuery) {
    return userSmsCodeRpc.listUserSmsCodes(listQuery);
  }

  @Override
  public TableResultResponse<UserSmsCodeRespDTO> page(
      @RequestBody UserSmsCodePageReqDTO pageReqDTO) {
    return userSmsCodeRpc.page(pageReqDTO);
  }

  @Override
  public ObjectRestResponse<UserSmsCodeRespDTO> getLastCodeByMobile(String mobile, Integer scene) {
    return userSmsCodeRpc.getLastCodeByMobile(mobile, scene);
  }
}
