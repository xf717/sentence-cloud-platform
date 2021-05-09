package com.db.chaomaxs.managementweb.convert.auth;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseResourceAuthorityAddDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseResourceAuthorityDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseResourceAuthorityPageDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseResourceAuthorityUpdateDTO;
import com.db.chaomaxs.managementweb.controller.auth.vo.BaseResourceAuthorityVO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseResourceAuthorityCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseResourceAuthorityListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseResourceAuthorityPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseResourceAuthorityRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseResourceAuthorityUpdateReqDTO;
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
public interface BaseResourceAuthorityConvert {

  BaseResourceAuthorityConvert INSTANCE = Mappers.getMapper(
      BaseResourceAuthorityConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseResourceAuthorityCreateReqDTO convert(BaseResourceAuthorityAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseResourceAuthorityUpdateReqDTO convert(BaseResourceAuthorityUpdateDTO updateDTO);

  @Mappings({})
  BaseResourceAuthorityListQueryReqDTO convert(BaseResourceAuthorityDTO baseResourceAuthorityDTO);

  /**
   * BO convert VO
   *
   * @param baseResourceAuthorityRespDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseResourceAuthorityVO convert(BaseResourceAuthorityRespDTO baseResourceAuthorityRespDTO);

  @Mappings({})
  List<BaseResourceAuthorityVO> convertList(List<BaseResourceAuthorityRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<BaseResourceAuthorityVO> convert(
      TableResultResponse<BaseResourceAuthorityRespDTO> tableResultResponse);

  @Mappings({})
  BaseResourceAuthorityPageReqDTO convert(
      BaseResourceAuthorityPageDTO baseResourceAuthorityPageDTO);

}
