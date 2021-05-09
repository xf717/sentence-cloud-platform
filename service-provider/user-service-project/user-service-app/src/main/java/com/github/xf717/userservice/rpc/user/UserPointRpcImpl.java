package com.github.xf717.userservice.rpc.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.user.UserPointManager;
import com.github.xf717.userservice.rpc.user.dto.UserPointCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserPointRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Slf4j
@Service
public class UserPointRpcImpl implements UserPointRpcFacade {

  @Autowired
  private UserPointManager userPointManager;

  @Override
  public BaseResponse save(UserPointCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userPointManager.saveUserPoint(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserPointUpdateReqDTO updateReqDTO) {
    userPointManager.updateUserPoint(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userPointManager.deleteUserPoint(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserPointRespDTO> getUserPointById(Long id) {
      UserPointRespDTO userPoint = userPointManager.getUserPointById(id);
    return new ObjectRestResponse<>().data(userPoint);
  }

  @Override
  public ObjectRestResponse<List<UserPointRespDTO>> listUserPoints(UserPointListQueryReqDTO listQuery) {
    List<UserPointRespDTO> list = userPointManager.listUserPoints(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserPointRespDTO> page(UserPointPageReqDTO pageReqDTO) {
    PageResult<UserPointRespDTO> pageResult = userPointManager.pageUserPoint(pageReqDTO);
    TableResultResponse<UserPointRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
