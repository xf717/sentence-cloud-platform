package com.db.chaomaxs.userservice.rpc.user;

import com.db.chaomaxs.common.framework.exception.enums.GlobalErrorCodeConstants;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.user.UserTrackManager;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPositionRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserTrackRpcFacade;
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
public class UserTrackRpcImpl implements UserTrackRpcFacade {

  @Autowired
  private UserTrackManager userTrackManager;

  @Override
  public BaseResponse save(UserTrackCreateReqDTO createReqDTO) {
    userTrackManager.saveUserTrack(createReqDTO);
    return BaseResponse.success("保存成功");
  }


  @Override
  public TableResultResponse<UserTrackRespDTO> page(UserTrackPageReqDTO pageReqDTO) {
    PageResult<UserTrackRespDTO> pageResult = userTrackManager.pageUserTrack(pageReqDTO);
    TableResultResponse<UserTrackRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    tableResultResponse.setCode(GlobalErrorCodeConstants.SUCCESS.getCode());
    return tableResultResponse;
  }

}
