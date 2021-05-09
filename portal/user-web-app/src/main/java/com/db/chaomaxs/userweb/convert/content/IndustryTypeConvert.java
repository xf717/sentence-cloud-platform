package com.db.chaomaxs.userweb.convert.content;

import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.db.chaomaxs.userweb.controller.content.vo.IndustryTypeVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换行业分类信息表
 *
 * @author ding
 * @date 2021-03-29 18:03:04
 */
@Mapper
public interface IndustryTypeConvert {

  IndustryTypeConvert INSTANCE = Mappers.getMapper(IndustryTypeConvert.class);


  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<IndustryTypeVO> convertList(List<IndustryTypeRespDTO> listResp);

}
