package com.db.chaomaxs.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserProjectExperienceDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserProjectExperienceConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Mapper
public interface UserProjectExperienceConvert {

        UserProjectExperienceConvert INSTANCE = Mappers.getMapper(UserProjectExperienceConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserProjectExperienceDO convert(UserProjectExperienceCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserProjectExperienceDO convert(UserProjectExperienceUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserProjectExperienceRespDTO> convertList(List<UserProjectExperienceDO> list);

  /**
   * 对象转换
   *
   * @param userProjectExperienceDO
   * @return
   */
      UserProjectExperienceRespDTO convert(UserProjectExperienceDO userProjectExperienceDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserProjectExperienceRespDTO> convertPage(IPage<UserProjectExperienceDO> page);


}
