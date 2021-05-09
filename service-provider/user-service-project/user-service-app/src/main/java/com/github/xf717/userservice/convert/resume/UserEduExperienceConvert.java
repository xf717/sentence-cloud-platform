package com.github.xf717.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserEduExperienceDO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserEduExperienceConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserEduExperienceConvert {

  UserEduExperienceConvert INSTANCE = Mappers.getMapper(UserEduExperienceConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserEduExperienceDO convert(UserEduExperienceCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserEduExperienceDO convert(UserEduExperienceUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserEduExperienceRespDTO> convertList(List<UserEduExperienceDO> list);

  /**
   * 对象转换
   *
   * @param userEduExperienceDO
   * @return
   */
  UserEduExperienceRespDTO convert(UserEduExperienceDO userEduExperienceDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserEduExperienceRespDTO> convertPage(IPage<UserEduExperienceDO> page);


}
