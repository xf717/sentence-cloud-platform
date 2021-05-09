package com.db.chaomaxs.userweb.convert.position;

import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.userweb.controller.position.vo.PositionTypeVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换职务职位分类信息表
 *
 * @author ding
 * @date 2021-04-06 17:45:09
 */
@Mapper
public interface PositionTypeConvert {

  PositionTypeConvert INSTANCE = Mappers.getMapper(PositionTypeConvert.class);


  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<PositionTypeVO> convertList(List<PositionTypeRespDTO> listResp);


}
