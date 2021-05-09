package com.db.chaomaxs.positionservice.convert.positiontype;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionKeywordDO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * PositionKeywordConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Mapper
public interface PositionKeywordConvert {

        PositionKeywordConvert INSTANCE = Mappers.getMapper(PositionKeywordConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      PositionKeywordDO convert(PositionKeywordCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      PositionKeywordDO convert(PositionKeywordUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<PositionKeywordRespDTO> convertList(List<PositionKeywordDO> list);

  /**
   * 对象转换
   *
   * @param positionKeywordDO
   * @return
   */
      PositionKeywordRespDTO convert(PositionKeywordDO positionKeywordDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<PositionKeywordRespDTO> convertPage(IPage<PositionKeywordDO> page);


}
