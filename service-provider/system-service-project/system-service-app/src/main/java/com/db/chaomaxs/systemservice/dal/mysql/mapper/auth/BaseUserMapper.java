package com.db.chaomaxs.systemservice.dal.mysql.mapper.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.systemservice.dal.mysql.dataobject.auth.BaseUserDO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Repository
public interface BaseUserMapper extends BaseMapper<BaseUserDO> {

  default List<BaseUserDO> selectList(BaseUserListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<BaseUserDO>());
  }

  default IPage<BaseUserDO> selectPage(BaseUserPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<BaseUserDO>());
  }

  BaseUserDO selectByUserName(@Param("userName") String userName);

  /**
   * 根据组id 查询用户
   *
   * @param groupId
   * @return
   */
  List<BaseUserDO> selectMemberByGroupId(@Param("groupId") Long groupId);

  /**
   * 根据组id 查询用户管理员
   *
   * @param groupId
   * @return
   */
  List<BaseUserDO> selectLeaderByGroupId(@Param("groupId") Long groupId);


}
