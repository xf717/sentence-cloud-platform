package com.db.chaomaxs.userservice.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.enums.CommonStatusEnum;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserThirdConvert;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserExtendDO;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserInfoDO;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserThirdDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserExtendMapper;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserInfoMapper;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserThirdMapper;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.enums.user.IdentityTypeEnum;
import com.db.chaomaxs.userservice.enums.user.RegisterTypeEnum;
import com.db.chaomaxs.userservice.enums.user.TerminalTypeEnum;
import com.db.chaomaxs.userservice.enums.user.UserRoleEnum;
import com.db.chaomaxs.userservice.enums.user.UserStatusEnum;
import com.db.chaomaxs.userservice.enums.user.UserTypeEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdUpdateReqDTO;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * UserThirdService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserThirdService {

  @Autowired
  private UserThirdMapper userThirdMapper;

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Autowired
  private UserExtendMapper userExtendMapper;


  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserThird(UserThirdCreateReqDTO createReqDTO) {
    return userThirdMapper.insert(UserThirdConvert.INSTANCE.convert(createReqDTO));
  }

  /**
   * 创建第三方帐号用户
   *
   * @param createReqDTO
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  @Deprecated
  public UserThirdRespDTO createUserThird(UserThirdCreateReqDTO createReqDTO) {
    int result = -1;
    // 先保存用户基础信息
    UserInfoDO userInfo = this.buildUserInfo(createReqDTO.getNickname(), createReqDTO.getMobile());
    result = userInfoMapper.insert(userInfo);
    if (result <= 0) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.CREATE_USER_ERROR.getCode());
    }
    UserThirdDO userThirdDO = UserThirdConvert.INSTANCE.convert(createReqDTO);
    userThirdDO.setUserId(userInfo.getId());
    // 直接保存当前第三方帐号，不存储其它用户信息和扩展表，在用户绑定的时候在进行操作
    result = userThirdMapper.insert(userThirdDO);
    if (result <= 0) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.CREATE_USER_THIRD_ERROR.getCode());
    }
    UserExtendDO userExtend = this
        .buildUserExtend(createReqDTO.getIp(), userInfo.getId(), createReqDTO.getGender());
    result = userExtendMapper.insert(userExtend);
    if (result <= 0) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.CREATE_USER_EXTEND_ERROR.getCode());
    }
    return UserThirdConvert.INSTANCE.convert(userThirdDO);
  }

  /**
   * 构建用户信息
   *
   * @param nickname
   * @return
   */
  private UserInfoDO buildUserInfo(String nickname, String mobile) {
    if (StringUtils.isEmpty(nickname)) {
      // 默认初始化一个昵称
      nickname =
          "chaomaxs_" + com.db.chaomaxs.common.framework.util.StringUtils.generateRandomCode(5);
    }
    UserInfoDO userInfoDO = new UserInfoDO()
        .setNickname(nickname)
        //第三方登录密码默认为随机码
        .setPassword(com.db.chaomaxs.common.framework.util.StringUtils.uuid(true))
        // 通过手机号码进行绑定
        .setMobile(mobile)
        .setUserStatus(UserStatusEnum.NORMAL.getValue())
        .setNickname(nickname)
        .setSignature("")
        .setAvatarUrl("")
        .setUserStatus(UserStatusEnum.NORMAL.getValue())
        .setUserType(UserTypeEnum.ORDINARY_USER.getValue());
    return userInfoDO;
  }

  /**
   * 构建扩展表信息
   *
   * @param ip
   * @param userId
   * @param gender
   * @return
   */
  private UserExtendDO buildUserExtend(String ip, Long userId, Integer gender) {
    final String defaultEmail = "chaomax_" + userId + "@126.com";
    UserExtendDO userExtend = new UserExtendDO()
        .setUserId(userId)
        .setEmail(defaultEmail)
        .setWeixin("")
        .setGender(gender)
        .setRealName("")
        .setIdcard(com.db.chaomaxs.common.framework.util.StringUtils.generateRandomCode(18))
        .setCompanyName("")
        .setRegisterTime(new Date())
        .setUserRole(UserRoleEnum.USER.getValue())
        .setIdentityType(IdentityTypeEnum.WORKPLACE.getValue())
        .setEnabledGreet(CommonStatusEnum.ENABLE.getValue())
        .setEnabledInterviewNotice(CommonStatusEnum.ENABLE.getValue())
        .setEnabledHide(CommonStatusEnum.DISABLE.getValue())
        .setRegisterIp(ip)
        .setRegisterType(RegisterTypeEnum.MOBILE.getValue())
        .setExpireFreeze(new Date())
        .setFreezeReason("")
        .setTerminalType(TerminalTypeEnum.WEB.getValue())
        .setTerminalSn("")
        .setTerminalName("");
    return userExtend;
  }


  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserThird(UserThirdUpdateReqDTO updateReqDTO) {
    UserThirdDO userThirdDO = userThirdMapper.selectById(updateReqDTO.getId());
    if (userThirdDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userThirdDO = UserThirdConvert.INSTANCE.convert(updateReqDTO);
    int result = userThirdMapper.updateById(userThirdDO);
    return result;
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserThird(Long id) {
    if (userThirdMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userThirdMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserThirdRespDTO> listUserThirds(UserThirdListQueryReqDTO listQueryReqDTO) {
    List<UserThirdDO> list = userThirdMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserThirdConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserThirdRespDTO getUserThirdById(Long id) {
    UserThirdDO userThirdDO = userThirdMapper.selectById(id);
    if (userThirdDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserThirdConvert.INSTANCE.convert(userThirdDO);
  }


  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserThirdRespDTO> pageUserThird(UserThirdPageReqDTO page) {
    IPage<UserThirdDO> userThirdPage = userThirdMapper.selectPage(page);
    return UserThirdConvert.INSTANCE.convertPage(userThirdPage);
  }

  /**
   * 根据thirdIden 查询用户
   *
   * @param thirdIden
   * @return
   */
  public UserThirdRespDTO getUserThirdByThirdIden(String thirdIden) {
    if (StringUtils.isEmpty(thirdIden)) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.THIRDIDEN_ERROR.getCode());
    }
    UserThirdDO userThirdDO = userThirdMapper.selectByThirdIden(thirdIden);
    return UserThirdConvert.INSTANCE.convert(userThirdDO);
  }

  /**
   * 根据用户id获取第三方用户信息
   *
   * @param userId
   * @return
   */
  public UserThirdRespDTO getUserThirdByUserId(Long userId) {
    if (userId == null || userId <= 0) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_THIRD_PARTY_BIND_ERROR.getCode());
    }
    UserThirdDO userThirdDO = userThirdMapper.selectByUserId(userId);
    return UserThirdConvert.INSTANCE.convert(userThirdDO);
  }


}
