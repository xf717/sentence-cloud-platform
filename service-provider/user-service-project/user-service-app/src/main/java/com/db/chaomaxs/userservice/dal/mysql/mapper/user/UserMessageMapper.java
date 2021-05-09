package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserMessageDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessageListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserMessagePageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户消息表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Repository
public interface UserMessageMapper extends BaseMapper<UserMessageDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserMessageDO> selectList(UserMessageListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserMessageDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserMessageDO> selectPage(UserMessagePageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserMessageDO>());
  }

}
