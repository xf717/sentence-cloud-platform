package com.github.xf717.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserProfessionalSkillDO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProfessionalSkillUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserProfessionalSkillConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserProfessionalSkillConvert {

        UserProfessionalSkillConvert INSTANCE = Mappers.getMapper(UserProfessionalSkillConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserProfessionalSkillDO convert(UserProfessionalSkillCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserProfessionalSkillDO convert(UserProfessionalSkillUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserProfessionalSkillRespDTO> convertList(List<UserProfessionalSkillDO> list);

  /**
   * 对象转换
   *
   * @param userProfessionalSkillDO
   * @return
   */
      UserProfessionalSkillRespDTO convert(UserProfessionalSkillDO userProfessionalSkillDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserProfessionalSkillRespDTO> convertPage(IPage<UserProfessionalSkillDO> page);

}
