package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.UserThirdRpcImpl;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.api.UserThirdApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@RestController
public class UserThirdRpcController implements UserThirdApi {

  @Autowired
  private UserThirdRpcImpl userThirdRpc;

  @Override
  public BaseResponse save(@RequestBody UserThirdCreateReqDTO createReqDTO) {
    return userThirdRpc.save(createReqDTO);
  }

  @Override
  public ObjectRestResponse<UserThirdRespDTO> createUserThirdIfAbsent(
      UserThirdCreateReqDTO createReqDTO) {
    return userThirdRpc.createUserThirdIfAbsent(createReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody UserThirdUpdateReqDTO updateReqDTO) {
    return userThirdRpc.update(updateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return userThirdRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<UserThirdRespDTO> getUserThirdById(@PathVariable("id") Long id) {
    return userThirdRpc.getUserThirdById(id);
  }

  @Override
  public ObjectRestResponse<List<UserThirdRespDTO>> listUserThirds(
      @RequestBody UserThirdListQueryReqDTO listQuery) {
    return userThirdRpc.listUserThirds(listQuery);
  }

  @Override
  public TableResultResponse<UserThirdRespDTO> page(@RequestBody UserThirdPageReqDTO pageReqDTO) {
    return userThirdRpc.page(pageReqDTO);
  }
}
