package com.github.xf717.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserWorkExperienceDO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperiencePageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_工作经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Repository
public interface UserWorkExperienceMapper extends BaseMapper<UserWorkExperienceDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserWorkExperienceDO> selectList(UserWorkExperienceListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserWorkExperienceDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserWorkExperienceDO> selectPage(UserWorkExperiencePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserWorkExperienceDO>());
  }

  /**
   *  根据简历id 查询工作经历
   * @param resumeId
   * @return
   */

  List<UserWorkExperienceDO> listWorkExperience(@Param("resumeId") Long resumeId);

  /**
   * 根据简历ids 查询工作经历
   * @param resumeIds
   * @return
   */

  List<UserWorkExperienceDO> listWorkExperienceByResumeIds(@Param("resumeIds") List<Long> resumeIds);

}
