package com.db.chaomaxs.resourceservice.rpc.resource;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.resourceservice.manager.resource.ResourceManager;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceCreateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourcePageReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceUpdateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.facade.ResourceRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Slf4j
@Service
public class ResourceRpcImpl implements ResourceRpcFacade {

  @Autowired
  private ResourceManager resourceManager;

  @Override
  public ObjectRestResponse<Long> save(ResourceCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    long resource = resourceManager.saveResource(createReqDTO);
    return ObjectRestResponse.success(resource);
  }

  @Override
  public BaseResponse update(ResourceUpdateReqDTO updateReqDTO) {
    resourceManager.updateResource(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    resourceManager.deleteResource(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<ResourceRespDTO> getResourceById(Long id) {
    ResourceRespDTO resource = resourceManager.getResourceById(id);
    return new ObjectRestResponse<>().data(resource);
  }

  @Override
  public ObjectRestResponse<List<ResourceRespDTO>> listResources(
      ResourceListQueryReqDTO listQuery) {
    List<ResourceRespDTO> list = resourceManager.listResources(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<ResourceRespDTO> page(ResourcePageReqDTO pageReqDTO) {
    PageResult<ResourceRespDTO> pageResult = resourceManager.pageResource(pageReqDTO);
    TableResultResponse<ResourceRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
