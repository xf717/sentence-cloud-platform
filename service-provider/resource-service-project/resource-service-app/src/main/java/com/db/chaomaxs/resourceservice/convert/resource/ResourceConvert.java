package com.db.chaomaxs.resourceservice.convert.resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.resourceservice.dal.mysql.dataobject.resource.ResourceDO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceCreateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * ResourceConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Mapper
public interface ResourceConvert {

  ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  ResourceDO convert(ResourceCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  ResourceDO convert(ResourceUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<ResourceRespDTO> convertList(List<ResourceDO> list);

  /**
   * 对象转换
   *
   * @param resourceDO
   * @return
   */
  ResourceRespDTO convert(ResourceDO resourceDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<ResourceRespDTO> convertPage(IPage<ResourceDO> page);


}
