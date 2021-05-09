package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserDeliveryDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import java.util.List;
import com.db.chaomaxs.userservice.rpc.user.dto.UserStatisticReqDTO;
import org.springframework.stereotype.Repository;

/**
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Repository
public interface UserDeliveryMapper extends BaseMapper<UserDeliveryDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserDeliveryDO> selectList(UserDeliveryListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserDeliveryDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<UserDeliveryDO> selectPage(UserDeliveryPageReqDTO pageReqDTO) {
    LambdaQueryWrapper<UserDeliveryDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.select(UserDeliveryDO::getId,UserDeliveryDO::getUserId,
        UserDeliveryDO::getCompanyUserId, UserDeliveryDO::getPositionId,
        UserDeliveryDO::getCreateTime);
    queryWrapper.eq(UserDeliveryDO::getUserId, pageReqDTO.getUserId());
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), queryWrapper);
  }

    UserDeliveryDO getByUserIdAndCompanyUserId(UserDeliveryDO userDeliveryDO);

    default Integer selectCount(UserStatisticReqDTO userStatisticReqDTO) {
        LambdaQueryWrapper<UserDeliveryDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserDeliveryDO::getUserId, userStatisticReqDTO.getUserId());
        return selectCount(wrapper);
    }
}
