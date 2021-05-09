package com.github.xf717.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserWorkExperienceDO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserWorkExperienceConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserWorkExperienceConvert {

        UserWorkExperienceConvert INSTANCE = Mappers.getMapper(UserWorkExperienceConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserWorkExperienceDO convert(UserWorkExperienceCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserWorkExperienceDO convert(UserWorkExperienceUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserWorkExperienceRespDTO> convertList(List<UserWorkExperienceDO> list);

  /**
   * 对象转换
   *
   * @param userWorkExperienceDO
   * @return
   */
      UserWorkExperienceRespDTO convert(UserWorkExperienceDO userWorkExperienceDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserWorkExperienceRespDTO> convertPage(IPage<UserWorkExperienceDO> page);


}
