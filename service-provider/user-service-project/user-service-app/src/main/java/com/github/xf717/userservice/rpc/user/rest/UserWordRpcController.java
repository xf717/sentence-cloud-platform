package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.UserWordRpcImpl;
import com.github.xf717.userservice.rpc.user.facade.api.UserWordApi;
import com.github.xf717.userservice.rpc.user.dto.UserWordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserWordPageReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_常用语
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@RestController
public class UserWordRpcController implements UserWordApi {

  @Autowired
  private UserWordRpcImpl userWordRpc;

  @Override
  public BaseResponse save(@RequestBody UserWordCreateReqDTO createReqDTO) {
    return userWordRpc.save(createReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody UserWordUpdateReqDTO updateReqDTO) {
    return userWordRpc.update(updateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return userWordRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<UserWordRespDTO> getUserWordById(@PathVariable("id") Long id) {
    return userWordRpc.getUserWordById(id);
  }

  @Override
  public TableResultResponse<UserWordRespDTO> page(@RequestBody UserWordPageReqDTO pageReqDTO) {
    return userWordRpc.page(pageReqDTO);
  }

  @Override
  public BaseResponse userWordTopByUserId(@PathVariable("id") Long id,
      @PathVariable("userId") Long userId) {
    return userWordRpc.userWordTopByUserId(id, userId);
  }
}
