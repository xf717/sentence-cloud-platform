package com.db.chaomaxs.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserProfessionalSkillDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProfessionalSkillPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_专业技能表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Repository
public interface UserProfessionalSkillMapper extends BaseMapper<UserProfessionalSkillDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserProfessionalSkillDO> selectList(UserProfessionalSkillListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserProfessionalSkillDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserProfessionalSkillDO> selectPage(UserProfessionalSkillPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserProfessionalSkillDO>());
  }

  /**
   * 根据简历id 查询专业技能
   * @param resumeId
   * @return
   */
  List<UserProfessionalSkillDO> listProfessionalSkill(@Param("resumeId") Long resumeId);
}
