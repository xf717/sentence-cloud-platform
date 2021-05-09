package com.db.chaomaxs.positionservice.convert.positiontype;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionKeywordExtendDO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * PositionKeywordExtendConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Mapper
public interface PositionKeywordExtendConvert {

        PositionKeywordExtendConvert INSTANCE = Mappers.getMapper(PositionKeywordExtendConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      PositionKeywordExtendDO convert(PositionKeywordExtendCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      PositionKeywordExtendDO convert(PositionKeywordExtendUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<PositionKeywordExtendRespDTO> convertList(List<PositionKeywordExtendDO> list);

  /**
   * 对象转换
   *
   * @param positionKeywordExtendDO
   * @return
   */
      PositionKeywordExtendRespDTO convert(PositionKeywordExtendDO positionKeywordExtendDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<PositionKeywordExtendRespDTO> convertPage(IPage<PositionKeywordExtendDO> page);


}
