package com.db.chaomaxs.positionservice.convert.positiontype;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionTypeDO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * PositionTypeConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Mapper
public interface PositionTypeConvert {

        PositionTypeConvert INSTANCE = Mappers.getMapper(PositionTypeConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      PositionTypeDO convert(PositionTypeCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      PositionTypeDO convert(PositionTypeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<PositionTypeRespDTO> convertList(List<PositionTypeDO> list);

  /**
   * 对象转换
   *
   * @param positionTypeDO
   * @return
   */
      PositionTypeRespDTO convert(PositionTypeDO positionTypeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<PositionTypeRespDTO> convertPage(IPage<PositionTypeDO> page);


}
