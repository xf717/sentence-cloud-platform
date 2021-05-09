package com.db.chaomaxs.userweb.convert.resume;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperiencePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceUpdateReqDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserEduExperienceAddDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserEduExperienceDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserEduExperiencePageDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserEduExperienceUpdateDTO;
import com.db.chaomaxs.userweb.controller.resume.vo.UniversityVO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserEduExperienceVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_教育经历表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserEduExperienceConvert {

  UserEduExperienceConvert INSTANCE = Mappers.getMapper(UserEduExperienceConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserEduExperienceCreateReqDTO convert(UserEduExperienceAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserEduExperienceUpdateReqDTO convert(UserEduExperienceUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userEduExperienceDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserEduExperienceListQueryReqDTO convert(UserEduExperienceDTO userEduExperienceDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({
      @Mapping(source = "startTime", target = "beginTime"),
      @Mapping(source = "endTime", target = "finishTime")
  })
  UserEduExperienceVO convert(UserEduExperienceRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserEduExperienceVO> convertList(List<UserEduExperienceRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserEduExperienceVO> convert(
      TableResultResponse<UserEduExperienceRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserEduExperiencePageReqDTO convert(UserEduExperiencePageDTO pageDTO);

  /**
   * 高校字典 convertToUniversity 转 UserEduExperienceVO
   *
   * @param respDTOList
   * @return
   */
  @Mappings({})
  List<UniversityVO> convertToUniversity(List<DataDictionaryItemRespDTO> respDTOList);

}
