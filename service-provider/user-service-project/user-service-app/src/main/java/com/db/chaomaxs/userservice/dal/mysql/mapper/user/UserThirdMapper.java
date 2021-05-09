package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserThirdDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdPageReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Repository
public interface UserThirdMapper extends BaseMapper<UserThirdDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserThirdDO> selectList(UserThirdListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserThirdDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<UserThirdDO> selectPage(UserThirdPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserThirdDO>());
  }

  /**
   * 根据第三方唯一标识查询第三方帐号
   *
   * @param thirdIden
   * @return
   */
  default UserThirdDO selectByThirdIden(String thirdIden) {
    return selectOne(new QueryWrapper<UserThirdDO>().eq("third_iden", thirdIden));
  }

  /**
   * 根据用户id 查询第三方信息
   *
   * @param userId
   * @return
   */
  default UserThirdDO selectByUserId(Long userId) {
    return selectOne(new QueryWrapper<UserThirdDO>().eq("user_id", userId));
  }

}
