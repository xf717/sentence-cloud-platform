package com.db.chaomaxs.systemservice.rpc.auth;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.manager.auth.BaseGroupMemberManager;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.facade.BaseGroupMemberRpcFacade;
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
