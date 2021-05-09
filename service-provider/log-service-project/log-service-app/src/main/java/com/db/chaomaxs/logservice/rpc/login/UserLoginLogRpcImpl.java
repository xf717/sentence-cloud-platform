package com.db.chaomaxs.logservice.rpc.login;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.logservice.manager.login.UserLoginLogManager;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogCreateReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogListQueryReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogPageReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogRespDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogUpdateReqDTO;
import com.db.chaomaxs.logservice.rpc.sms.facade.UserLoginLogRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:03
 */
@Slf4j
@Service
public class UserLoginLogRpcImpl implements UserLoginLogRpcFacade {

  @Autowired
  private UserLoginLogManager userLoginLogManager;

  @Override
  public BaseResponse save(UserLoginLogCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userLoginLogManager.saveUserLoginLog(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserLoginLogUpdateReqDTO updateReqDTO) {
      userLoginLogManager.updateUserLoginLog(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userLoginLogManager.deleteUserLoginLog(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserLoginLogRespDTO> getUserLoginLogById(Long id) {
      UserLoginLogRespDTO userLoginLog = userLoginLogManager.getUserLoginLogById(id);
    return new ObjectRestResponse<>().data(userLoginLog);
  }

  @Override
  public ObjectRestResponse<List<UserLoginLogRespDTO>> listUserLoginLogs(UserLoginLogListQueryReqDTO listQuery) {
    List<UserLoginLogRespDTO> list = userLoginLogManager.listUserLoginLogs(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserLoginLogRespDTO> page(UserLoginLogPageReqDTO pageReqDTO) {
    PageResult<UserLoginLogRespDTO> pageResult = userLoginLogManager.pageUserLoginLog(pageReqDTO);
    TableResultResponse<UserLoginLogRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
