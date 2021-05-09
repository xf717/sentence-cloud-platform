package com.github.xf717.systemservice.convert.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.WorkContentDO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentDetailRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * WorkContentConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface WorkContentConvert {

        WorkContentConvert INSTANCE = Mappers.getMapper(WorkContentConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      WorkContentDO convert(WorkContentCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      WorkContentDO convert(WorkContentUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<WorkContentRespDTO> convertList(List<WorkContentDO> list);

  /**
   * 对象转换
   *
   * @param workContentDO
   * @return
   */
      WorkContentRespDTO convert(WorkContentDO workContentDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<WorkContentRespDTO> convertPage(IPage<WorkContentDO> page);

  /**
   * 对象转换
   *
   * @param workContentResp
   * @return
   */
  WorkContentDetailRespDTO convert(WorkContentRespDTO workContentResp);

  /**
   * 对象转换
   *
   * @param workContentExtend
   * @return
   */
  WorkContentDetailRespDTO convert(WorkContentExtendRespDTO workContentExtend);

}
