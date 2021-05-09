package com.db.chaomaxs.resourceservice.rpc.resource.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.resourceservice.rpc.resource.ResourceRpcImpl;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceCreateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourcePageReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceUpdateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.facade.api.ResourceApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@RestController
public class ResourceRpcController implements ResourceApi {

  @Autowired
  private ResourceRpcImpl resourceRpc;

  @Override
  public ObjectRestResponse<Long> save(@RequestBody ResourceCreateReqDTO createReqDTO) {
    return resourceRpc.save(createReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody ResourceUpdateReqDTO updateReqDTO) {
    return resourceRpc.update(updateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return resourceRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<ResourceRespDTO> getResourceById(@PathVariable("id") Long id) {
    return resourceRpc.getResourceById(id);
  }

  @Override
  public ObjectRestResponse<List<ResourceRespDTO>> listResources(
      @RequestBody ResourceListQueryReqDTO listQuery) {
    return resourceRpc.listResources(listQuery);
  }

  @Override
  public TableResultResponse<ResourceRespDTO> page(@RequestBody ResourcePageReqDTO pageReqDTO) {
    return resourceRpc.page(pageReqDTO);
  }
}
