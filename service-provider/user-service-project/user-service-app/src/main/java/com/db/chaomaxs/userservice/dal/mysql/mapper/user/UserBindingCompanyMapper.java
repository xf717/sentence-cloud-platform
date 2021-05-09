package com.db.chaomaxs.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserBindingCompanyDO;
import com.db.chaomaxs.userservice.enums.user.UserBindingStateEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingCompanyPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingStateUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBindingTransferReqDTO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 用户_企业绑定
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Repository
public interface UserBindingCompanyMapper extends BaseMapper<UserBindingCompanyDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserBindingCompanyDO> selectList(UserBindingCompanyListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserBindingCompanyDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<UserBindingCompanyDO> selectPage(UserBindingCompanyPageReqDTO pageReqDTO) {
    LambdaQueryWrapper<UserBindingCompanyDO> wrapper = Wrappers.lambdaQuery();
    if (pageReqDTO.getBindingState() != null) {
      if (UserBindingStateEnum.UNBOUND.getValue().equals(pageReqDTO.getBindingState())) {
        wrapper.ne(UserBindingCompanyDO::getBindingState, UserBindingStateEnum.UNBIND.getValue());
      } else {
        wrapper.eq(UserBindingCompanyDO::getBindingState, pageReqDTO.getBindingState());
      }
    }
    wrapper.eq(UserBindingCompanyDO::getCompanyId, pageReqDTO.getCompanyId());
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), wrapper);
  }

  /**
   * 修改绑定状态
   * @param bindingStateUpdateReqDTO
   */
  default void updateBindingState(UserBindingStateUpdateReqDTO bindingStateUpdateReqDTO) {
    LambdaUpdateWrapper<UserBindingCompanyDO> wrapper = Wrappers.lambdaUpdate();
    wrapper.eq(UserBindingCompanyDO::getId, bindingStateUpdateReqDTO.getId())
        .eq(UserBindingCompanyDO::getCompanyId, bindingStateUpdateReqDTO.getCompanyId())
        .set(UserBindingCompanyDO::getBindingState, bindingStateUpdateReqDTO.getBindingState());
    update(null, wrapper);
  }

  /**
   * 获取公司所有绑定用
   * @param companyId
   * @return
   */
  default List<UserBindingCompanyDO> getAllBindingUser(Long companyId) {
    return selectList(Wrappers.<UserBindingCompanyDO>lambdaQuery()
        .eq(UserBindingCompanyDO::getCompanyId, companyId));
  }

  /**
   * 修改交接状态及交接人
   * @param userBindingTransferReqDTO
   * @return
   */
  default void handover(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    update(null, Wrappers.<UserBindingCompanyDO>lambdaUpdate()
        .eq(UserBindingCompanyDO::getCompanyId, userBindingTransferReqDTO.getCompanyId())
        .eq(UserBindingCompanyDO::getUserId, userBindingTransferReqDTO.getUserId())
        .set(UserBindingCompanyDO::getHandover, 1)
        .set(UserBindingCompanyDO::getHandoverUserId, userBindingTransferReqDTO.getTransferToUserId()));
  }

  /**
   * 移除用户管理员
   * @param userBindingTransferReqDTO
   * @param isManager
   */
  default void removeManager(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    update(null, Wrappers.<UserBindingCompanyDO>lambdaUpdate()
        .eq(UserBindingCompanyDO::getCompanyId, userBindingTransferReqDTO.getCompanyId())
        .eq(UserBindingCompanyDO::getUserId, userBindingTransferReqDTO.getUserId())
        .set(UserBindingCompanyDO::getManager, 0));
  }

  /**
   * 修改用户为管理员
   * @param userBindingTransferReqDTO
   * @param isManager
   */
  default void updateManager(UserBindingTransferReqDTO userBindingTransferReqDTO) {
    update(null, Wrappers.<UserBindingCompanyDO>lambdaUpdate()
        .eq(UserBindingCompanyDO::getCompanyId, userBindingTransferReqDTO.getCompanyId())
        .eq(UserBindingCompanyDO::getUserId, userBindingTransferReqDTO.getTransferToUserId())
        .set(UserBindingCompanyDO::getManager, 1));
  }

}
