package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserIntegralRecordDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserIntegralRecordPageReqDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 记录用户签到记录信息
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Repository
public interface UserIntegralRecordMapper extends BaseMapper<UserIntegralRecordDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserIntegralRecordDO> selectList(UserIntegralRecordListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserIntegralRecordDO>());
  }

  /**
  * 查询分页
  *
  * @param pageReqDTO
  * @return
  */
  default IPage<UserIntegralRecordDO> selectPage(UserIntegralRecordPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserIntegralRecordDO>());
  }

  /**
   * 根据用户查询最新签到记录
   * @param userId
   * @return
   */
  UserIntegralRecordDO selectByUserId(@Param("userId") Long userId);

}
