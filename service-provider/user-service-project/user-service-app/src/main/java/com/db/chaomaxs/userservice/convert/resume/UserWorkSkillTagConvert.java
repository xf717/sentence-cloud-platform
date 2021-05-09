package com.db.chaomaxs.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserWorkSkillTagDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserWorkSkillTagConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserWorkSkillTagConvert {

        UserWorkSkillTagConvert INSTANCE = Mappers.getMapper(UserWorkSkillTagConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserWorkSkillTagDO convert(UserWorkSkillTagCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserWorkSkillTagDO convert(UserWorkSkillTagUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserWorkSkillTagRespDTO> convertList(List<UserWorkSkillTagDO> list);

  /**
   * 对象转换
   *
   * @param userWorkSkillTagDO
   * @return
   */
      UserWorkSkillTagRespDTO convert(UserWorkSkillTagDO userWorkSkillTagDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserWorkSkillTagRespDTO> convertPage(IPage<UserWorkSkillTagDO> page);


}
