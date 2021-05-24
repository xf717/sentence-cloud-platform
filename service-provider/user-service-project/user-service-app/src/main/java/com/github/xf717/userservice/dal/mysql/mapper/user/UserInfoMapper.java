package com.github.xf717.userservice.dal.mysql.mapper.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xf717.mybatis.core.query.QueryWrapperX;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserInfoDO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoPageReqDTO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfoDO> {

  /**
   * 根据参数查询数据
   *
   * @param listReqDTO
   * @return
   */
  default List<UserInfoDO> selectList(UserInfoListQueryReqDTO listReqDTO) {
    return selectList(new QueryWrapperX<UserInfoDO>());
  }

  /**
   * 查询分页
   *
   * @param pageReqDTO
   * @return
   */
  default IPage<UserInfoDO> selectPage(UserInfoPageReqDTO pageReqDTO) {
    return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()),
        new QueryWrapperX<UserInfoDO>());
  }

  /**
   * 根据手机号码查询用户
   *
   * @param mobile
   * @return
   */
  default UserInfoDO selectByMobile(String mobile) {
//    return selectOne(new QueryWrapper<UserInfoDO>().eq("mobile", mobile));
    // 返回指定的数据列名
    LambdaQueryWrapper<UserInfoDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(UserInfoDO::getMobile, mobile)
        .select(UserInfoDO::getId,
            UserInfoDO::getMobile,
            UserInfoDO::getNickname,
            UserInfoDO::getUserStatus);
    return selectOne(queryWrapper);
  }

  /**
   * 查询密码
   * @param mobile 手机号码
   * @return
   */
  default UserInfoDO selectPassword(String mobile) {
    LambdaQueryWrapper<UserInfoDO> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(UserInfoDO::getMobile, mobile)
        .select(UserInfoDO::getId,
            UserInfoDO::getMobile,
            UserInfoDO::getPassword,
            UserInfoDO::getUserStatus);
    return selectOne(queryWrapper);
  }

  /**
   * 根据用户id 查询用户信息
   *
   * @param userId
   * @return
   */
  UserInfoDO selectUserInfoByUserId(@Param("userId") Long userId);

  /**
   * 根据用户ids 查询用户信息
   * @param userIds
   * @return
   */
  List<UserInfoDO> listUserInfoByUserIds(@Param("userIds") Set<Long> userIds);
  
}
