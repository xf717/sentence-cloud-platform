package com.github.xf717.resourceweb.convert.resource;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.resourceservice.rpc.resource.dto.ResourceCreateReqDTO;
import com.github.xf717.resourceservice.rpc.resource.dto.ResourceListQueryReqDTO;
import com.github.xf717.resourceservice.rpc.resource.dto.ResourcePageReqDTO;
import com.github.xf717.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.github.xf717.resourceservice.rpc.resource.dto.ResourceUpdateReqDTO;
import com.github.xf717.resourceweb.controller.resource.dto.ResourceAddDTO;
import com.github.xf717.resourceweb.controller.resource.dto.ResourceDTO;
import com.github.xf717.resourceweb.controller.resource.dto.ResourcePageDTO;
import com.github.xf717.resourceweb.controller.resource.dto.ResourceUpdateDTO;
import com.github.xf717.resourceweb.controller.resource.vo.ResourceVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Mapper
public interface ResourceConvert {

  ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  ResourceCreateReqDTO convert(ResourceAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  ResourceUpdateReqDTO convert(ResourceUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param resourceDTO 查询参数对象
   * @return
   */
  @Mappings({})
  ResourceListQueryReqDTO convert(ResourceDTO resourceDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  ResourceVO convert(ResourceRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<ResourceVO> convertList(List<ResourceRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<ResourceVO> convert(
      TableResultResponse<ResourceRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  ResourcePageReqDTO convert(ResourcePageDTO pageDTO);

}
