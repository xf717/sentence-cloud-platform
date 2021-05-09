package com.db.chaomaxs.resourceservice.service.resource;

import static com.db.chaomaxs.resourceservice.enums.ResourceErrorCodeConstants.RESOURCE_SAVE_ERROR;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.resourceservice.convert.resource.ResourceConvert;
import com.db.chaomaxs.resourceservice.dal.mysql.dataobject.resource.ResourceDO;
import com.db.chaomaxs.resourceservice.dal.mysql.mapper.resource.ResourceMapper;
import com.db.chaomaxs.resourceservice.enums.ResourceErrorCodeConstants;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceCreateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourcePageReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ResourceService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class ResourceService {

  @Autowired
  private ResourceMapper resourceMapper;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveResource(ResourceCreateReqDTO createReqDTO) {
    ResourceDO resource = ResourceConvert.INSTANCE.convert(createReqDTO);
    int result = resourceMapper.insert(resource);
    if (result <= 0) {
      throw ServiceExceptionUtil.exception(RESOURCE_SAVE_ERROR);
    }
    // 返回保存后的id
    return resource.getId().intValue();
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateResource(ResourceUpdateReqDTO updateReqDTO) {
    ResourceDO resourceDO = resourceMapper.selectById(updateReqDTO.getId());
    if (resourceDO == null) {
      throw ServiceExceptionUtil
          .exception(ResourceErrorCodeConstants.RESOURCE_NOT_EXISTS.getCode());
    }
    resourceDO = ResourceConvert.INSTANCE.convert(updateReqDTO);
    int result = resourceMapper.updateById(resourceDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteResource(Long id) {
    if (resourceMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(ResourceErrorCodeConstants.RESOURCE_NOT_EXISTS.getCode());
    }
    int result = resourceMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<ResourceRespDTO> listResources(ResourceListQueryReqDTO listQueryReqDTO) {
    List<ResourceDO> list = resourceMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return ResourceConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public ResourceRespDTO getResourceById(Long id) {
    ResourceDO resourceDO = resourceMapper.selectById(id);
    if (resourceDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(ResourceErrorCodeConstants.RESOURCE_NOT_EXISTS.getCode());
    }
    return ResourceConvert.INSTANCE.convert(resourceDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<ResourceRespDTO> pageResource(ResourcePageReqDTO page) {
    IPage<ResourceDO> resourcePage = resourceMapper.selectPage(page);
    return ResourceConvert.INSTANCE.convertPage(resourcePage);
  }


}
