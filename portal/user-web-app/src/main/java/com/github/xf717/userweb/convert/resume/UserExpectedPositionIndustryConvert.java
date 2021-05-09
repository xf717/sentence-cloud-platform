package com.github.xf717.userweb.convert.resume;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionIndustryAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionIndustryDTO;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionIndustryPageDTO;
import com.github.xf717.userweb.controller.resume.dto.UserExpectedPositionIndustryUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserExpectedPositionIndustryVO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Mapper
public interface UserExpectedPositionIndustryConvert {

  UserExpectedPositionIndustryConvert INSTANCE = Mappers
      .getMapper(UserExpectedPositionIndustryConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserExpectedPositionIndustryCreateReqDTO convert(UserExpectedPositionIndustryAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserExpectedPositionIndustryUpdateReqDTO convert(
      UserExpectedPositionIndustryUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userExpectedPositionIndustryDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserExpectedPositionIndustryListQueryReqDTO convert(
      UserExpectedPositionIndustryDTO userExpectedPositionIndustryDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserExpectedPositionIndustryVO convert(UserExpectedPositionIndustryRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserExpectedPositionIndustryVO> convertList(
      List<UserExpectedPositionIndustryRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserExpectedPositionIndustryVO> convert(
      TableResultResponse<UserExpectedPositionIndustryRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserExpectedPositionIndustryPageReqDTO convert(UserExpectedPositionIndustryPageDTO pageDTO);

}
