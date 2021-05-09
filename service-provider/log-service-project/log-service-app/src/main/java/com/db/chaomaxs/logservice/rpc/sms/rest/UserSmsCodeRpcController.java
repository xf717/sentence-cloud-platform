package com.db.chaomaxs.logservice.rpc.sms.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.logservice.rpc.sms.UserSmsCodeRpcImpl;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeCreateReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeListQueryReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodePageReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeUpdateReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.facade.api.UserSmsCodeApi;
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
