package com.db.chaomaxs.positionservice.dal.mysql.mapper.position;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.UserPositionWantedDO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户求职
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Repository
public interface UserPositionWantedMapper extends BaseMapper<UserPositionWantedDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserPositionWantedDO> selectList(UserPositionWantedListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserPositionWantedDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserPositionWantedDO> selectPage(UserPositionWantedPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserPositionWantedDO>());
  }

}
