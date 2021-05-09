package com.db.chaomaxs.managementweb.convert.auth;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupMemberAddDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupMemberDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupMemberPageDTO;
import com.db.chaomaxs.managementweb.controller.auth.dto.BaseGroupMemberUpdateDTO;
import com.db.chaomaxs.managementweb.controller.auth.vo.BaseGroupMemberVO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupMemberUpdateReqDTO;
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
public interface BaseGroupMemberConvert {

  BaseGroupMemberConvert INSTANCE = Mappers.getMapper(
      BaseGroupMemberConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupMemberCreateReqDTO convert(BaseGroupMemberAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupMemberUpdateReqDTO convert(BaseGroupMemberUpdateDTO updateDTO);

  @Mappings({})
  BaseGroupMemberListQueryReqDTO convert(BaseGroupMemberDTO baseGroupMemberDTO);

  /**
   * BO convert VO
   *
   * @param baseGroupMemberRespDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseGroupMemberVO convert(BaseGroupMemberRespDTO baseGroupMemberRespDTO);

  @Mappings({})
  List<BaseGroupMemberVO> convertList(List<BaseGroupMemberRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<BaseGroupMemberVO> convert(
      TableResultResponse<BaseGroupMemberRespDTO> tableResultResponse);

  @Mappings({})
  BaseGroupMemberPageReqDTO convert(BaseGroupMemberPageDTO baseGroupMemberPageDTO);

}
