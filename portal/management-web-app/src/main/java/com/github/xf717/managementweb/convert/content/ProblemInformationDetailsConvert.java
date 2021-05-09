package com.github.xf717.managementweb.convert.content;

import com.github.xf717.managementweb.controller.content.vo.ProblemInformationDetailsVO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换内容管理-问题详情信息
 *
 * @author dind
 * @date 2021-04-15
 */
@Mapper
public interface ProblemInformationDetailsConvert {

  ProblemInformationDetailsConvert INSTANCE = Mappers.getMapper(
      ProblemInformationDetailsConvert.class);


  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  ProblemInformationDetailsVO convert(ProblemInformationRespDTO respDTO);

}
