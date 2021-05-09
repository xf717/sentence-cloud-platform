package com.github.xf717.userservice.rpc.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.manager.user.UserIntegralRecordManager;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserIntegralRecordRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Slf4j
@Service
public class UserIntegralRecordRpcImpl implements UserIntegralRecordRpcFacade {

  @Autowired
  private UserIntegralRecordManager userIntegralRecordManager;

  @Override
  public BaseResponse save(UserIntegralRecordCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userIntegralRecordManager.saveUserIntegralRecord(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserIntegralRecordUpdateReqDTO updateReqDTO) {
    userIntegralRecordManager.updateUserIntegralRecord(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userIntegralRecordManager.deleteUserIntegralRecord(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserIntegralRecordRespDTO> getUserIntegralRecordById(Long id) {
      UserIntegralRecordRespDTO userIntegralRecord = userIntegralRecordManager.getUserIntegralRecordById(id);
    return new ObjectRestResponse<>().data(userIntegralRecord);
  }

  @Override
  public ObjectRestResponse<List<UserIntegralRecordRespDTO>> listUserIntegralRecords(UserIntegralRecordListQueryReqDTO listQuery) {
    List<UserIntegralRecordRespDTO> list = userIntegralRecordManager.listUserIntegralRecords(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserIntegralRecordRespDTO> page(UserIntegralRecordPageReqDTO pageReqDTO) {
    PageResult<UserIntegralRecordRespDTO> pageResult = userIntegralRecordManager.pageUserIntegralRecord(pageReqDTO);
    TableResultResponse<UserIntegralRecordRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public BaseResponse sign(Long userId) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userIntegralRecordManager.sign(userId);
    return BaseResponse.success("签到成功");
  }
}
