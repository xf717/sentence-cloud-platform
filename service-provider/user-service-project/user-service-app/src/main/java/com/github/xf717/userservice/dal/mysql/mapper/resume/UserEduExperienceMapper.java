package com.github.xf717.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserEduExperienceDO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperiencePageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_教育经历表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Repository
public interface UserEduExperienceMapper extends BaseMapper<UserEduExperienceDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserEduExperienceDO> selectList(UserEduExperienceListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserEduExperienceDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<UserEduExperienceDO> selectPage(UserEduExperiencePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserEduExperienceDO>());
  }

  /**
   * 根据简历id 查询教育经历
   *
   * @param resumeId
   * @return
   */

  List<UserEduExperienceDO> listEduExperience(@Param("resumeId") Long resumeId);

  /**
   * 根据简历ids 查询最高学历
   *
   * @param resumeIds
   * @return
   */
  List<UserEduExperienceDO> listEduExperienceByResumeIds(@Param("resumeIds") List<Long> resumeIds);

  /**
   * 根据简历id获取最新学历
   *
   * @param resumeId
   * @return
   */
  String selectEducation(@Param("resumeId") Long resumeId);

  UserEduExperienceDO selectEduExperience(@Param("resumeId") Long resumeId);

}
