package com.github.xf717.userweb.convert.resume;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeUpdateReqDTO;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionDTO;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionPageDTO;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionUpdateDTO;
import com.github.xf717.userweb.controller.resume.dto.UserPositionWantedStatusDTO;
import com.github.xf717.userweb.controller.resume.vo.UserExpectedPositionVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserExpectedPositionConvert {

  UserExpectedPositionConvert INSTANCE = Mappers.getMapper(UserExpectedPositionConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserExpectedPositionCreateReqDTO convert(UserExpectedPositionAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserExpectedPositionUpdateReqDTO convert(UserExpectedPositionUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userExpectedPositionDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserExpectedPositionListQueryReqDTO convert(UserExpectedPositionDTO userExpectedPositionDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserExpectedPositionVO convert(UserExpectedPositionRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserExpectedPositionVO> convertList(List<UserExpectedPositionRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserExpectedPositionVO> convert(
      TableResultResponse<UserExpectedPositionRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserExpectedPositionPageReqDTO convert(UserExpectedPositionPageDTO pageDTO);

  /**
   * 对象转成 UserResumeUpdateReqDTO
   * @param updateDTO
   * @return
   */
  @Mapping(source = "updateDTO.userResumeId", target = "id")
  @Mapping(source = "updateDTO.positionWantedDictionaryId", target = "positionWantedDictionaryId")
  @Mapping(source = "updateDTO.positionWantedStatusName", target = "positionWantedStatusName")
  UserResumeUpdateReqDTO convert(UserPositionWantedStatusDTO updateDTO);

}
