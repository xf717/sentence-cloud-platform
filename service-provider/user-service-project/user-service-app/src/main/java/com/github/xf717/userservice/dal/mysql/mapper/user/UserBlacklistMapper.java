package com.github.xf717.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserBlacklistDO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBlacklistPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户_黑名单
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Repository
public interface UserBlacklistMapper extends BaseMapper<UserBlacklistDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserBlacklistDO> selectList(UserBlacklistListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserBlacklistDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserBlacklistDO> selectPage(UserBlacklistPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserBlacklistDO>());
  }

}
