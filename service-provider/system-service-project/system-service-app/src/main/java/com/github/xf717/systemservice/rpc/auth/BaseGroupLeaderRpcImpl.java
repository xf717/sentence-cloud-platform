package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.auth.BaseGroupLeaderManager;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseGroupLeaderRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseGroupLeaderRpcImpl implements BaseGroupLeaderRpcFacade {

  @Autowired
  private BaseGroupLeaderManager baseGroupLeaderManager;

  @Override
  public BaseResponse save(BaseGroupLeaderCreateReqDTO baseGroupLeaderCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    baseGroupLeaderManager.saveBaseGroupLeader(baseGroupLeaderCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(BaseGroupLeaderUpdateReqDTO baseGroupLeaderUpdateReqDTO) {
    baseGroupLeaderManager.updateBaseGroupLeader(baseGroupLeaderUpdateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    baseGroupLeaderManager.deleteBaseGroupLeader(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<BaseGroupLeaderRespDTO> getBaseGroupLeaderById(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<List<BaseGroupLeaderRespDTO>> listBaseGroupLeaders(
      BaseGroupLeaderListQueryReqDTO listQuery) {
    return null;
  }

  @Override
  public TableResultResponse<BaseGroupLeaderRespDTO> page(BaseGroupLeaderPageReqDTO pageReqDTO) {
    PageResult<BaseGroupLeaderRespDTO> pageResult = baseGroupLeaderManager
        .pageBaseGroupLeader(pageReqDTO);
    TableResultResponse<BaseGroupLeaderRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
