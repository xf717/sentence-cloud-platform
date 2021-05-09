package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.auth.BaseGroupMemberManager;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseGroupMemberRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseGroupMemberRpcImpl implements BaseGroupMemberRpcFacade {

  @Autowired
  private BaseGroupMemberManager baseGroupMemberManager;

  @Override
  public BaseResponse save(BaseGroupMemberCreateReqDTO baseGroupMemberCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    baseGroupMemberManager.saveBaseGroupMember(baseGroupMemberCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(BaseGroupMemberUpdateReqDTO baseGroupMemberUpdateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse remove(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<BaseGroupMemberRespDTO> getBaseGroupMemberById(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<List<BaseGroupMemberRespDTO>> listBaseGroupMembers(
      BaseGroupMemberListQueryReqDTO listQuery) {
    return null;
  }

  @Override
  public TableResultResponse<BaseGroupMemberRespDTO> page(BaseGroupMemberPageReqDTO pageReqDTO) {
    PageResult<BaseGroupMemberRespDTO> pageResult = baseGroupMemberManager
        .pageBaseGroupMember(pageReqDTO);
    TableResultResponse<BaseGroupMemberRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
