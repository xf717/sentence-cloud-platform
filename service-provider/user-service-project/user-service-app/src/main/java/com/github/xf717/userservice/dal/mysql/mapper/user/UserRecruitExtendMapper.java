package com.github.xf717.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserRecruitExtendDO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendPageReqDTO;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 * 用户_招聘_扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:54:37
 */
@Repository
public interface UserRecruitExtendMapper extends BaseMapper<UserRecruitExtendDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserRecruitExtendDO> selectList(UserRecruitExtendListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserRecruitExtendDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserRecruitExtendDO> selectPage(UserRecruitExtendPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserRecruitExtendDO>());
  }

  /**
   * 根据userIds查询
   * @param userIds
   * @return
   */
  default List<UserRecruitExtendDO> getByUserIds(Set<Long> userIds) {
    return selectList(Wrappers.<UserRecruitExtendDO>lambdaQuery()
        .in(UserRecruitExtendDO::getUserId, userIds));
  }

}
