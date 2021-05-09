package com.db.chaomaxs.managementweb.convert.auth;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupTypeAddDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupTypeDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupTypePageDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupTypeUpdateDTO;
import com.db.chaomaxs.managementweb.controller.auth.vo.BaseGroupTypeVO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseGroupTypeConvert {

  BaseGroupTypeConvert INSTANCE = Mappers.getMapper(
      BaseGroupTypeConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupTypeCreateReqDTO convert(BaseGroupTypeAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupTypeUpdateReqDTO convert(BaseGroupTypeUpdateDTO updateDTO);

  @Mappings({})
  BaseGroupTypeListQueryReqDTO convert(BaseGroupTypeDTO baseGroupTypeDTO);

  /**
   * BO convert VO
   *
   * @param baseGroupTypeRespDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupTypeVO convert(BaseGroupTypeRespDTO baseGroupTypeRespDTO);

  @Mappings({})
  List<BaseGroupTypeVO> convertList(List<BaseGroupTypeRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<BaseGroupTypeVO> convert(
      TableResultResponse<BaseGroupTypeRespDTO> tableResultResponse);

  @Mappings({})
  BaseGroupTypePageReqDTO convert(BaseGroupTypePageDTO baseGroupTypePageDTO);

}
