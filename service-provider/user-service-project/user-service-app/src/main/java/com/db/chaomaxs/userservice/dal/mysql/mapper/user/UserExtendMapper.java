package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserExtendDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendPageReqDTO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_基础信息扩展表
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Repository
public interface UserExtendMapper extends BaseMapper<UserExtendDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserExtendDO> selectList(UserExtendListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserExtendDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserExtendDO> selectPage(UserExtendPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserExtendDO>());
  }

  /**
   * 根据用户id 查询真实姓名
   * @param userId
   * @return
   */
  UserExtendDO selectByUserId(@Param("userId")Long userId);

  /**
   * 根据用户ids 查询 拓展信息
   * @param userIds
   * @return
   */
  List<UserExtendDO> selectByUserIds(@Param("userIds")Set<Long> userIds);



}
