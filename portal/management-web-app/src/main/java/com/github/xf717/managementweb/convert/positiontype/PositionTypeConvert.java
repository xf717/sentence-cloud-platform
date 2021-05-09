package com.github.xf717.managementweb.convert.positiontype;

import com.github.xf717.managementweb.controller.positiontype.dto.PositionTypeAddDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionTypeDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionTypePageDTO;
import com.github.xf717.managementweb.controller.positiontype.dto.PositionTypeUpdateDTO;
import com.github.xf717.managementweb.controller.positiontype.vo.PositionTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypePageReqDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.github.xf717.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;


/**
 * 应用层实体对象转换职务职位分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Mapper
public interface PositionTypeConvert {

  PositionTypeConvert INSTANCE = Mappers.getMapper(PositionTypeConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  PositionTypeCreateReqDTO convert(PositionTypeAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  PositionTypeUpdateReqDTO convert(PositionTypeUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param positionTypeDTO 查询参数对象
   * @return
   */
  @Mappings({})
  PositionTypeListQueryReqDTO convert(PositionTypeDTO positionTypeDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  PositionTypeVO convert(PositionTypeRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<PositionTypeVO> convertList(List<PositionTypeRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<PositionTypeVO> convert(
      TableResultResponse<PositionTypeRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  PositionTypePageReqDTO convert(PositionTypePageDTO pageDTO);

}
