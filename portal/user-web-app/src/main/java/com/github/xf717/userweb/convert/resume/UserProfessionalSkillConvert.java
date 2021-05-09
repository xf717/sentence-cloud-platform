package com.github.xf717.userweb.convert.resume;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillUpdateReqDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProfessionalSkillAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProfessionalSkillDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProfessionalSkillPageDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProfessionalSkillUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserProfessionalSkillVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserProfessionalSkillConvert {

  UserProfessionalSkillConvert INSTANCE = Mappers.getMapper(UserProfessionalSkillConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserProfessionalSkillCreateReqDTO convert(UserProfessionalSkillAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserProfessionalSkillUpdateReqDTO convert(UserProfessionalSkillUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userProfessionalSkillDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserProfessionalSkillListQueryReqDTO convert(
      UserProfessionalSkillDTO userProfessionalSkillDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserProfessionalSkillVO convert(UserProfessionalSkillRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserProfessionalSkillVO> convertList(List<UserProfessionalSkillRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserProfessionalSkillVO> convert(
      TableResultResponse<UserProfessionalSkillRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserProfessionalSkillPageReqDTO convert(UserProfessionalSkillPageDTO pageDTO);

}
