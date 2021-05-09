package com.github.xf717.userservice.rpc.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.manager.resume.UserExpectedPositionManager;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedAndStatusRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserExpectedPositionRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Slf4j
@Service
public class UserExpectedPositionRpcImpl implements UserExpectedPositionRpcFacade {

  @Autowired
  private UserExpectedPositionManager userExpectedPositionManager;

  @Override
  public BaseResponse save(UserExpectedPositionCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userExpectedPositionManager.saveUserExpectedPosition(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserExpectedPositionUpdateReqDTO updateReqDTO) {
    userExpectedPositionManager.updateUserExpectedPosition(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userExpectedPositionManager.deleteUserExpectedPosition(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserExpectedPositionRespDTO> getUserExpectedPositionById(Long id) {
    UserExpectedPositionRespDTO userExpectedPosition = userExpectedPositionManager.getUserExpectedPositionById(id);
    return new ObjectRestResponse<>().data(userExpectedPosition);
  }

  @Override
  public ObjectRestResponse<UserExpectedAndStatusRespDTO> getUserExpectedAndStatusByUserId(Long userId) {
    UserExpectedAndStatusRespDTO userExpectedAndStatusRespDTO = userExpectedPositionManager.getUserExpectedAndStatusByUserId(userId);
    return new ObjectRestResponse<>().data(userExpectedAndStatusRespDTO);
  }

}
