package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.auth.BaseResourceAuthorityManager;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseResourceAuthorityUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseResourceAuthorityRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseResourceAuthorityRpcImpl implements BaseResourceAuthorityRpcFacade {

  @Autowired
  private BaseResourceAuthorityManager baseResourceAuthorityManager;

  @Override
  public BaseResponse save(BaseResourceAuthorityCreateReqDTO baseResourceAuthorityCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    baseResourceAuthorityManager.saveBaseResourceAuthority(baseResourceAuthorityCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(BaseResourceAuthorityUpdateReqDTO baseResourceAuthorityUpdateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse remove(Long id) {
    baseResourceAuthorityManager.deleteBaseResourceAuthority(id);
    return BaseResponse.success("删除成功");

  }

  @Override
  public ObjectRestResponse<BaseResourceAuthorityRespDTO> getBaseResourceAuthorityById(Long id) {
    BaseResourceAuthorityRespDTO baseResourceAuthorityRespDTO = baseResourceAuthorityManager
        .getBaseResourceAuthorityById(id);
    return new ObjectRestResponse<>().data(baseResourceAuthorityRespDTO);
  }

  @Override
  public ObjectRestResponse<List<BaseResourceAuthorityRespDTO>> listBaseResourceAuthoritys(
      BaseResourceAuthorityListQueryReqDTO listQuery) {
    List<BaseResourceAuthorityRespDTO> list = baseResourceAuthorityManager
        .listBaseResourceAuthoritys(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<BaseResourceAuthorityRespDTO> page(
      BaseResourceAuthorityPageReqDTO pageReqDTO) {
    PageResult<BaseResourceAuthorityRespDTO> pageResult = baseResourceAuthorityManager
        .pageBaseResourceAuthority(pageReqDTO);
    TableResultResponse<BaseResourceAuthorityRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
