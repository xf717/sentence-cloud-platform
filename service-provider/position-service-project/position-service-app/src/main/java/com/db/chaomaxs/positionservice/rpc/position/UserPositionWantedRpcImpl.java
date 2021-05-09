package com.db.chaomaxs.positionservice.rpc.position;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.manager.position.UserPositionWantedManager;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.UserPositionWantedRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Slf4j
@Service
public class UserPositionWantedRpcImpl implements UserPositionWantedRpcFacade {

  @Autowired
  private UserPositionWantedManager userPositionWantedManager;

  @Override
  public BaseResponse save(UserPositionWantedCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userPositionWantedManager.saveUserPositionWanted(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserPositionWantedUpdateReqDTO updateReqDTO) {
      userPositionWantedManager.updateUserPositionWanted(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      userPositionWantedManager.deleteUserPositionWanted(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserPositionWantedRespDTO> getUserPositionWantedById(Long id) {
      UserPositionWantedRespDTO userPositionWanted = userPositionWantedManager.getUserPositionWantedById(id);
    return new ObjectRestResponse<>().data(userPositionWanted);
  }

  @Override
  public ObjectRestResponse<List<UserPositionWantedRespDTO>> listUserPositionWanteds(UserPositionWantedListQueryReqDTO listQuery) {
    List<UserPositionWantedRespDTO> list = userPositionWantedManager.listUserPositionWanteds(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserPositionWantedRespDTO> page(UserPositionWantedPageReqDTO pageReqDTO) {
    PageResult<UserPositionWantedRespDTO> pageResult = userPositionWantedManager.pageUserPositionWanted(pageReqDTO);
    TableResultResponse<UserPositionWantedRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
