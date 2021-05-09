package com.github.xf717.userservice.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.exception.ServiceException;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.user.UserExtendConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserExtendDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserInfoDO;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserExtendMapper;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserInfoMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.rpc.user.dto.UserExtendCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * UserExtendService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserExtendService {

  @Autowired
  private UserExtendMapper userExtendMapper;

  @Autowired
  private UserInfoMapper userInfoMapper;


  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int saveUserExtend(UserExtendCreateReqDTO createReqDTO) {

    // 更新用户信息
    if (createReqDTO.getAvatarUrl() != null) {
      UserInfoDO userInfoDO = userInfoMapper.selectById(createReqDTO.getUserId());
      userInfoDO.setAvatarUrl(createReqDTO.getAvatarUrl());
      userInfoMapper.updateById(userInfoDO);
    }
    //新增拓展信息
    UserExtendDO userExtendDO = new UserExtendDO();
    userExtendDO.setUserId(createReqDTO.getUserId());
    userExtendDO.setGender(createReqDTO.getGender());
    userExtendDO.setRealName(createReqDTO.getRealName());
    userExtendDO.setIdentityType(createReqDTO.getIdentityType());
    int result = userExtendMapper.insert(userExtendDO);
    return result;
  }


  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserExtend(Long id) {
    if (userExtendMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userExtendMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserExtendRespDTO> listUserExtends(UserExtendListQueryReqDTO listQueryReqDTO) {
    List<UserExtendDO> list = userExtendMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserExtendConvert.INSTANCE.convertList(list);
  }


  /**
   * 根据用户id查询拓展信息
   *
   * @param userId
   * @return
   */
  public UserExtendRespDTO getUserExtendByUserId(Long userId) {
    UserExtendDO userExtendDO = userExtendMapper.selectByUserId(userId);
    if (userExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_EXTEND_NOT_EXISTS.getCode());
    }
    return UserExtendConvert.INSTANCE.convert(userExtendDO);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserExtendRespDTO> pageUserExtend(UserExtendPageReqDTO page) {
    IPage<UserExtendDO> userExtendPage = userExtendMapper.selectPage(page);
    return UserExtendConvert.INSTANCE.convertPage(userExtendPage);
  }

  /**
   * 根据用户ids 查询
   *
   * @param userIds 用户ids
   * @return
   */
  public List<UserExtendRespDTO> listUserExtendByUserIds(Set<Long> userIds) {
    List<UserExtendDO> userExtendList = userExtendMapper.selectByUserIds(userIds);
    if (CollectionUtils.isEmpty(userExtendList)) {
      return Collections.emptyList();
    }
    return UserExtendConvert.INSTANCE.convertList(userExtendList);
  }

  /**
   * 更新按钮开关数据
   *
   * @param updateEnableHideReqDTO
   * @return
   */
  public int updateEnableHideDTO(UserExtendUpdateEnableHideReqDTO updateEnableHideReqDTO) {
    UserExtendDO userExtendDO = userExtendMapper.selectByUserId(updateEnableHideReqDTO.getUserId());
    if (userExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USERNAME_NOT_EXISTS.getCode());
    }
    if (updateEnableHideReqDTO.getEnabledGreet() != null) {
      userExtendDO.setEnabledGreet(updateEnableHideReqDTO.getEnabledGreet());
    }
    if (updateEnableHideReqDTO.getEnabledHide() != null) {
      userExtendDO.setEnabledHide(updateEnableHideReqDTO.getEnabledHide());
    }
    if (updateEnableHideReqDTO.getEnabledInterviewNotice() != null) {
      userExtendDO.setEnabledInterviewNotice(updateEnableHideReqDTO.getEnabledInterviewNotice());
    }
    return userExtendMapper.updateById(userExtendDO);
  }

  /**
   * 招聘者注册时更新用户拓展信息
   *
   * @param userRecruitUpdateReqDTO
   * @return
   */
  public int updateUserExtendReqDto(UserRecruitUpdateReqDTO userRecruitUpdateReqDTO) {
    if (null == userRecruitUpdateReqDTO.getUserId()) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    UserExtendDO userExtendDO = userExtendMapper.selectOne(new LambdaQueryWrapper<UserExtendDO>()
        .eq(UserExtendDO::getUserId, userRecruitUpdateReqDTO.getUserId()).select(UserExtendDO::getId));
    if (userExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    UserExtendDO newUserExtendDO = UserExtendConvert.INSTANCE.convert(userRecruitUpdateReqDTO);
    newUserExtendDO.setId(userExtendDO.getId());
    return userExtendMapper.updateById(newUserExtendDO);
  }


}
