package com.db.chaomaxs.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserProjectExperienceDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperiencePageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_项目经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Repository
public interface UserProjectExperienceMapper extends BaseMapper<UserProjectExperienceDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserProjectExperienceDO> selectList(UserProjectExperienceListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserProjectExperienceDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserProjectExperienceDO> selectPage(UserProjectExperiencePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserProjectExperienceDO>());
  }

  /**
   * 根据简历id 查询项目经历
   * @param resumeId
   * @return
   */
  List<UserProjectExperienceDO> listProjectExperience(@Param("resumeId") Long resumeId);


}
