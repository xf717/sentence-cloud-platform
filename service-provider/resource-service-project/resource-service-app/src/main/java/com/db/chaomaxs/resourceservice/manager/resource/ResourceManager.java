package com.db.chaomaxs.resourceservice.manager.resource;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceCreateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourcePageReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceUpdateReqDTO;
import com.db.chaomaxs.resourceservice.service.resource.ResourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ResourceManager
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Service
@Validated
public class ResourceManager {

  @Autowired
  private ResourceService resourceService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveResource(ResourceCreateReqDTO createReqDTO) {
    return resourceService.saveResource(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateResource(ResourceUpdateReqDTO updateReqDTO) {
    return resourceService.updateResource(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteResource(Long id) {
    return resourceService.deleteResource(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<ResourceRespDTO> listResources(ResourceListQueryReqDTO listQueryReqDTO) {
    return resourceService.listResources(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public ResourceRespDTO getResourceById(Long id) {
    return resourceService.getResourceById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<ResourceRespDTO> pageResource(ResourcePageReqDTO page) {
    return resourceService.pageResource(page);
  }


}
