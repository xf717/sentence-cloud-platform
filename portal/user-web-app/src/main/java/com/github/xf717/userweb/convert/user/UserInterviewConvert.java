package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.companyservice.rpc.interview.dto.CompanyUserInterviewRespDTO;
import com.github.xf717.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserInterviewAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserInterviewDTO;
import com.github.xf717.userweb.controller.user.dto.UserInterviewPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserInterviewUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserInterviewVO;
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
