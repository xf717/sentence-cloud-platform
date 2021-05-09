package com.github.xf717.systemservice.convert.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.ProblemInformationExtendDO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * ProblemInformationExtendConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface ProblemInformationExtendConvert {

        ProblemInformationExtendConvert INSTANCE = Mappers.getMapper(ProblemInformationExtendConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      ProblemInformationExtendDO convert(ProblemInformationExtendCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      ProblemInformationExtendDO convert(ProblemInformationExtendUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<ProblemInformationExtendRespDTO> convertList(List<ProblemInformationExtendDO> list);

  /**
   * 对象转换
   *
   * @param problemInformationExtendDO
   * @return
   */
      ProblemInformationExtendRespDTO convert(ProblemInformationExtendDO problemInformationExtendDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<ProblemInformationExtendRespDTO> convertPage(IPage<ProblemInformationExtendDO> page);


}
