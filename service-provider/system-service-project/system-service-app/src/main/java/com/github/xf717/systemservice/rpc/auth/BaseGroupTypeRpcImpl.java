package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.auth.BaseGroupTypeManager;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypePageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseGroupTypeRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseGroupTypeRpcImpl implements BaseGroupTypeRpcFacade {

  @Autowired
  private BaseGroupTypeManager baseGroupTypeManager;

  @Override
  public BaseResponse save(BaseGroupTypeCreateReqDTO baseGroupTypeCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    baseGroupTypeManager.saveBaseGroupType(baseGroupTypeCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(BaseGroupTypeUpdateReqDTO baseGroupTypeUpdateReqDTO) {
    baseGroupTypeManager.updateBaseGroupType(baseGroupTypeUpdateReqDTO);
    return BaseResponse.success("修改成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    baseGroupTypeManager.deleteBaseGroupType(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<BaseGroupTypeRespDTO> getBaseGroupTypeById(Long id) {
    BaseGroupTypeRespDTO baseGroupTypeRespDTO = baseGroupTypeManager.getBaseGroupTypeById(id);
    return new ObjectRestResponse<>().data(baseGroupTypeRespDTO);
  }

  @Override
  public ObjectRestResponse<List<BaseGroupTypeRespDTO>> listBaseGroupTypes(
      BaseGroupTypeListQueryReqDTO listQuery) {
    List<BaseGroupTypeRespDTO> list = baseGroupTypeManager.listBaseGroupTypes(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<BaseGroupTypeRespDTO> page(BaseGroupTypePageReqDTO pageReqDTO) {
    PageResult<BaseGroupTypeRespDTO> pageResult = baseGroupTypeManager
        .pageBaseGroupType(pageReqDTO);
    TableResultResponse<BaseGroupTypeRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
