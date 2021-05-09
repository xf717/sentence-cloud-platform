package com.github.xf717.userservice.dal.mysql.mapper.resume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserResumeDO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumePageReqDTO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Repository
public interface UserResumeMapper extends BaseMapper<UserResumeDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserResumeDO> selectList(UserResumeListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserResumeDO>());
  }

  /**
   * 根据用户id 查询在线简历
   * @param userId
   * @return
   */
  UserResumeDO selectByUserId(@Param("userId")Long userId);


  /**
   * 根据用户ids 查询
   * @param userIds
   * @return
   */
  List<UserResumeDO> selectByUserIds(@Param("userIds") Set<Long> userIds);

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserResumeDO> selectPage(UserResumePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserResumeDO>());
  }

}
