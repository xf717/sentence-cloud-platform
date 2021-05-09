package com.db.chaomaxs.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.mapper.CommonMapper;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserWorkSkillTagDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserWorkSkillTagPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_工作经历_技能标签信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Repository
public interface UserWorkSkillTagMapper extends CommonMapper<UserWorkSkillTagDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserWorkSkillTagDO> selectList(UserWorkSkillTagListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserWorkSkillTagDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserWorkSkillTagDO> selectPage(UserWorkSkillTagPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserWorkSkillTagDO>());
  }

  /**
   * 根据工作经历ids 查询工作标签
   * @param workExperienceIds
   * @return
   */
  List<UserWorkSkillTagDO> listByWorkExperienceIds(@Param("ids") List<Long> workExperienceIds);


  /**
   * 根据参数查询数据
   *
   * @param workExperienceId
   */
  default void deleteByWorkExperience(Long workExperienceId) {
    delete(new QueryWrapperX<UserWorkSkillTagDO>().eq("work_experience_id", workExperienceId));
  }

  /**
   * 根据工作经历id 查询工作标签
   *
   * @param workExperienceId
   * @return
   */
  List<UserWorkSkillTagDO> listByWorkExperienceId(@Param("id") Long workExperienceId);

  /**
   * 批量插入工作技能标签
   * @param tagList
   */
  void batchInsert(@Param("tagList") List<UserWorkSkillTagDO> tagList );
}
