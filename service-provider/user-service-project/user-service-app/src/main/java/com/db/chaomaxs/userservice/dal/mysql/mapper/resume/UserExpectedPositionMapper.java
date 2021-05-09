package com.db.chaomaxs.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.resume.UserExpectedPositionDO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_期望职位
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Repository
public interface UserExpectedPositionMapper extends BaseMapper<UserExpectedPositionDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserExpectedPositionDO> selectList(UserExpectedPositionListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserExpectedPositionDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserExpectedPositionDO> selectPage(UserExpectedPositionPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserExpectedPositionDO>());
  }

  /**
   * 根据简历id 查询期望职位
   * @param resumeId
   * @return
   */
  List<UserExpectedPositionDO> listExpectedPosition(@Param("resumeId") Long resumeId);

  List<UserExpectedPositionDO> listExpectedPositionByresumeIds(@Param("resumeIds")List<Long> resumeIds);
}
