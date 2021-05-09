package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserPointDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Repository
public interface UserPointMapper extends BaseMapper<UserPointDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserPointDO> selectList(UserPointListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserPointDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserPointDO> selectPage(UserPointPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserPointDO>());
  }

}
