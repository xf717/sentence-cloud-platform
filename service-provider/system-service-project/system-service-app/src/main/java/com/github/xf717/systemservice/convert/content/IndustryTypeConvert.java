package com.github.xf717.systemservice.convert.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.IndustryTypeDO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * IndustryTypeConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface IndustryTypeConvert {

        IndustryTypeConvert INSTANCE = Mappers.getMapper(IndustryTypeConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      IndustryTypeDO convert(IndustryTypeCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      IndustryTypeDO convert(IndustryTypeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<IndustryTypeRespDTO> convertList(List<IndustryTypeDO> list);

  /**
   * 对象转换
   *
   * @param industryTypeDO
   * @return
   */
      IndustryTypeRespDTO convert(IndustryTypeDO industryTypeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<IndustryTypeRespDTO> convertPage(IPage<IndustryTypeDO> page);


}
