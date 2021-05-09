package com.db.chaomaxs.userweb.convert.resume;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyFullNameRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentDetailRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkExperiencePageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkExperienceUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserWorkExperienceAddDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserWorkExperienceDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserWorkExperiencePageDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserWorkExperienceUpdateDTO;
import com.db.chaomaxs.userweb.controller.resume.vo.CompanyVO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserReferenceVO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserWorkExperienceVO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserWorkSkillTagVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_工作经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserWorkExperienceConvert {

  UserWorkExperienceConvert INSTANCE = Mappers.getMapper(UserWorkExperienceConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserWorkExperienceCreateReqDTO convert(UserWorkExperienceAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserWorkExperienceUpdateReqDTO convert(UserWorkExperienceUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userWorkExperienceDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserWorkExperienceListQueryReqDTO convert(UserWorkExperienceDTO userWorkExperienceDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserWorkExperienceVO convert(UserWorkExperienceRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserWorkExperienceVO> convertList(List<UserWorkExperienceRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserWorkExperienceVO> convert(
      TableResultResponse<UserWorkExperienceRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserWorkExperiencePageReqDTO convert(UserWorkExperiencePageDTO pageDTO);

  /**
   * list 转换成 VO list
   * @param workSkillTagList
   * @return
   */
  @Mappings({})
  List<UserWorkSkillTagVO> convertTagList(List<UserWorkSkillTagRespDTO> workSkillTagList);


  /**
   * list 转换成 VO list
   * @param list
   * @return
   */
  List<CompanyVO> convertToList(List<CompanyFullNameRespDTO> list);

  /**
   *
   * workContentDetailRespDTO 转 vo
   * @param workContentDetailRespDTO
   * @return
   */
  @Mappings({})
  UserReferenceVO convert(WorkContentDetailRespDTO workContentDetailRespDTO);

}
