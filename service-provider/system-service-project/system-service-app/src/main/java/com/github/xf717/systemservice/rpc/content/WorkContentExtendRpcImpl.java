package com.github.xf717.systemservice.rpc.content;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.content.WorkContentExtendManager;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.facade.WorkContentExtendRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Slf4j
@Service
public class WorkContentExtendRpcImpl implements WorkContentExtendRpcFacade {

  @Autowired
  private WorkContentExtendManager workContentExtendManager;

  @Override
  public BaseResponse save(WorkContentExtendCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    workContentExtendManager.saveWorkContentExtend(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(WorkContentExtendUpdateReqDTO updateReqDTO) {
      workContentExtendManager.updateWorkContentExtend(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      workContentExtendManager.deleteWorkContentExtend(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<WorkContentExtendRespDTO> getWorkContentExtendById(Long id) {
      WorkContentExtendRespDTO workContentExtend = workContentExtendManager.getWorkContentExtendById(id);
    return new ObjectRestResponse<>().data(workContentExtend);
  }

  @Override
  public ObjectRestResponse<List<WorkContentExtendRespDTO>> listWorkContentExtends(WorkContentExtendListQueryReqDTO listQuery) {
    List<WorkContentExtendRespDTO> list = workContentExtendManager.listWorkContentExtends(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<WorkContentExtendRespDTO> page(WorkContentExtendPageReqDTO pageReqDTO) {
    PageResult<WorkContentExtendRespDTO> pageResult = workContentExtendManager.pageWorkContentExtend(pageReqDTO);
    TableResultResponse<WorkContentExtendRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
