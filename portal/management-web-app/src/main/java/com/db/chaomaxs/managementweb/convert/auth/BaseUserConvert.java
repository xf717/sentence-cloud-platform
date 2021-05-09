package com.db.chaomaxs.managementweb.convert.auth;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseUserAddDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseUserDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseUserPageDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseUserUpdateDTO;
import com.db.chaomaxs.managementweb.controller.auth.vo.BaseUserVO;
import com.db.chaomaxs.managementweb.controller.auth.vo.FrontUserV2VO;
import com.db.chaomaxs.managementweb.controller.auth.vo.FrontUserVO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.FrontUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.FrontUserV2RespDTO;
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
public interface BaseUserConvert {

  BaseUserConvert INSTANCE = Mappers.getMapper(
      BaseUserConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseUserCreateReqDTO convert(BaseUserAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseUserUpdateReqDTO convert(BaseUserUpdateDTO updateDTO);

  @Mappings({})
  BaseUserListQueryReqDTO convert(BaseUserDTO baseUserDTO);

  /**
   * BO convert VO
   *
   * @param baseUserRespDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseUserVO convert(BaseUserRespDTO baseUserRespDTO);

  @Mappings({})
  List<BaseUserVO> convertList(List<BaseUserRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<BaseUserVO> convert(
      TableResultResponse<BaseUserRespDTO> tableResultResponse);

  @Mappings({})
  BaseUserPageReqDTO convert(BaseUserPageDTO baseUserPageDTO);

  /**
   * 前端用户数据转换
   *
   * @param frontUserRespDTO
   * @return
   */
  FrontUserVO convert(FrontUserRespDTO frontUserRespDTO);

  /**
   * 前端用户数据转换
   *
   * @param frontUserV2RespDTO
   * @return
   */
  FrontUserV2VO convert(FrontUserV2RespDTO frontUserV2RespDTO);
  

}
