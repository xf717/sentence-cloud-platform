package com.db.chaomaxs.logservice.dal.mysql.mapper.login;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.logservice.dal.mysql.dataobject.login.UserLoginLogDO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogListQueryReqDTO;
import com.db.chaomaxs.logservice.rpc.login.dto.UserLoginLogPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户_登录日志
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:03
 */
@Repository
public interface UserLoginLogMapper extends BaseMapper<UserLoginLogDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserLoginLogDO> selectList(UserLoginLogListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserLoginLogDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserLoginLogDO> selectPage(UserLoginLogPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserLoginLogDO>());
  }

}
