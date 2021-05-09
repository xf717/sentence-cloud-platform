package com.db.chaomaxs.managementweb.convert.positiontype;

import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionKeywordExtendAddDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionKeywordExtendDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionKeywordExtendPageDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.dto.PositionKeywordExtendUpdateDTO;
import com.db.chaomaxs.managementweb.controller.positiontype.vo.PositionKeywordExtendVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendUpdateReqDTO;


/**
 * 应用层实体对象转换职务关键词-扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Mapper
public interface PositionKeywordExtendConvert {

  PositionKeywordExtendConvert INSTANCE = Mappers.getMapper(PositionKeywordExtendConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  PositionKeywordExtendCreateReqDTO convert(PositionKeywordExtendAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  PositionKeywordExtendUpdateReqDTO convert(PositionKeywordExtendUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param positionKeywordExtendDTO 查询参数对象
   * @return
   */
  @Mappings({})
  PositionKeywordExtendListQueryReqDTO convert(
      PositionKeywordExtendDTO positionKeywordExtendDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  PositionKeywordExtendVO convert(PositionKeywordExtendRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<PositionKeywordExtendVO> convertList(List<PositionKeywordExtendRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<PositionKeywordExtendVO> convert(
      TableResultResponse<PositionKeywordExtendRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  PositionKeywordExtendPageReqDTO convert(PositionKeywordExtendPageDTO pageDTO);

}
