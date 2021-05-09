package com.db.chaomaxs.systemservice.rpc.content;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.manager.content.WorkContentManager;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentDetailRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.WorkContentRpcFacade;
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
public class WorkContentRpcImpl implements WorkContentRpcFacade {

  @Autowired
  private WorkContentManager workContentManager;

  @Override
  public BaseResponse save(WorkContentCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    workContentManager.saveWorkContent(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(WorkContentUpdateReqDTO updateReqDTO) {
    workContentManager.updateWorkContent(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    workContentManager.deleteWorkContent(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<WorkContentRespDTO> getWorkContentById(Long id) {
    WorkContentRespDTO workContent = workContentManager.getWorkContentById(id);
    return new ObjectRestResponse<>().data(workContent);
  }

  @Override
  public ObjectRestResponse<List<WorkContentRespDTO>> listWorkContents(
      WorkContentListQueryReqDTO listQuery) {
    List<WorkContentRespDTO> list = workContentManager.listWorkContents(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<WorkContentRespDTO> page(WorkContentPageReqDTO pageReqDTO) {
    PageResult<WorkContentRespDTO> pageResult = workContentManager.pageWorkContent(pageReqDTO);
    TableResultResponse<WorkContentRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<WorkContentDetailRespDTO> workContentDetail() {
    WorkContentDetailRespDTO workContentDetail = workContentManager.workContentDetail();
    return new ObjectRestResponse<>().data(workContentDetail);
  }

}
