package com.db.chaomaxs.userweb.convert.user;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewRespDTO;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserInterviewAddDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserInterviewDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserInterviewPageDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserInterviewUpdateDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserInterviewVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Mapper
public interface UserInterviewConvert {

  UserInterviewConvert INSTANCE = Mappers.getMapper(UserInterviewConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserInterviewCreateReqDTO convert(UserInterviewAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserInterviewUpdateReqDTO convert(UserInterviewUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userInterviewDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserInterviewListQueryReqDTO convert(UserInterviewDTO userInterviewDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserInterviewVO convert(UserInterviewRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserInterviewVO> convertList(List<UserInterviewRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserInterviewVO> convert(
      TableResultResponse<UserInterviewRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserInterviewPageReqDTO convert(UserInterviewPageDTO pageDTO);

  /**
   * list 转换成 VO list
   *
   * @param respDTOList
   * @return
   */
  @Mappings({})
  List<UserInterviewVO> convertToList(List<CompanyUserInterviewRespDTO> respDTOList);

  /**
   * 用户面试转换企业面试
   * @param updateDTO
   * @return
   */
  @Mapping(source = "updateDTO.companyUserInterviewId", target = "id")
  @Mapping(source = "updateDTO.status", target = "status")
  CompanyUserInterviewUpdateStateReqDTO convertToCompanyInterview(UserInterviewUpdateDTO updateDTO);

}
