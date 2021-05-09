package com.github.xf717.systemservice.convert.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.WorkContentExtendDO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * WorkContentExtendConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface WorkContentExtendConvert {

        WorkContentExtendConvert INSTANCE = Mappers.getMapper(WorkContentExtendConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      WorkContentExtendDO convert(WorkContentExtendCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      WorkContentExtendDO convert(WorkContentExtendUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<WorkContentExtendRespDTO> convertList(List<WorkContentExtendDO> list);

  /**
   * 对象转换
   *
   * @param workContentExtendDO
   * @return
   */
      WorkContentExtendRespDTO convert(WorkContentExtendDO workContentExtendDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<WorkContentExtendRespDTO> convertPage(IPage<WorkContentExtendDO> page);


}
