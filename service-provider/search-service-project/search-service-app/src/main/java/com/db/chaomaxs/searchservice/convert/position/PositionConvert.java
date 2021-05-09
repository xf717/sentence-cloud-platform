package com.db.chaomaxs.searchservice.convert.position;


import com.db.chaomaxs.searchservice.dal.es.dataobject.position.PositionEsDO;
import com.db.chaomaxs.searchservice.rpc.position.dto.PositionEsCreateReqDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.PositionEsRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ResourceConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Mapper
public interface PositionConvert {

  PositionConvert INSTANCE = Mappers.getMapper(PositionConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  PositionEsDO convert(PositionEsCreateReqDTO createReqDTO);


  List<PositionEsRespDTO> convertList(List<PositionEsDO> positionEsDOList);
}
