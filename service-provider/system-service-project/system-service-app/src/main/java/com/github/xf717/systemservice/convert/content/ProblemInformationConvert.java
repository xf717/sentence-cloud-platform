package com.github.xf717.systemservice.convert.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.ProblemInformationDO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * ProblemInformationConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface ProblemInformationConvert {

        ProblemInformationConvert INSTANCE = Mappers.getMapper(ProblemInformationConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      ProblemInformationDO convert(ProblemInformationCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      ProblemInformationDO convert(ProblemInformationUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<ProblemInformationRespDTO> convertList(List<ProblemInformationDO> list);

  /**
   * 对象转换
   *
   * @param problemInformationDO
   * @return
   */
      ProblemInformationRespDTO convert(ProblemInformationDO problemInformationDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<ProblemInformationRespDTO> convertPage(IPage<ProblemInformationDO> page);


}
