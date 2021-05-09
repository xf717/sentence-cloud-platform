package com.github.xf717.userservice.service.user;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.enums.CommonStatusEnum;
import com.github.xf717.common.framework.exception.ServiceException;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.util.StringUtils;
import com.github.xf717.common.framework.util.password.Sha256PasswordEncoder;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.convert.user.UserInfoConvert;
import com.github.xf717.userservice.convert.user.UserThirdConvert;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserResumeDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserExtendDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserInfoDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserPersonalInfoDO;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserThirdDO;
import com.github.xf717.userservice.dal.mysql.mapper.resume.UserResumeMapper;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserExtendMapper;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserInfoMapper;
import com.github.xf717.userservice.dal.mysql.mapper.user.UserThirdMapper;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.enums.user.GenderEnum;
import com.github.xf717.userservice.enums.user.IdentityTypeEnum;
import com.github.xf717.userservice.enums.user.LoginRegisterSourceEnum;
import com.github.xf717.userservice.enums.user.TerminalTypeEnum;
import com.github.xf717.userservice.enums.user.UserLoginTypeEnum;
import com.github.xf717.userservice.enums.user.UserRoleEnum;
import com.github.xf717.userservice.enums.user.UserStatusEnum;
import com.github.xf717.userservice.enums.user.UserTypeEnum;
import com.github.xf717.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * UserInfoService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class UserInfoService {

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Autowired
  private UserExtendMapper userExtendMapper;

  @Autowired
  private UserThirdMapper userThirdMapper;
  @Autowired
  private UserResumeMapper userResumeMapper;


  /**
   * 加密
   */
  private Sha256PasswordEncoder encoder = new Sha256PasswordEncoder();


  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserInfo(UserInfoCreateReqDTO createReqDTO) {
    return userInfoMapper.insert(UserInfoConvert.INSTANCE.convert(createReqDTO));
  }

  @Transactional(rollbackFor = Exception.class)
  public UserInfoRespDTO createUser(UserInfoCreateReqDTO createReqDTO) {
    UserInfoDO userInfoDO = UserInfoConvert.INSTANCE.convert(createReqDTO);
    final UserLoginTypeEnum userLoginTypeEnum = UserLoginTypeEnum
        .getInstance(createReqDTO.getUserLoginType());
    userInfoDO = this.buildUserInfo(userInfoDO);
    int result = userInfoMapper.insert(userInfoDO);
    if (result > 0) {
      // 保存用户成功后添加用户扩展信息
      UserExtendDO userExtend = buildUserExtend(createReqDTO.getRegisterIp(), userInfoDO.getId(),
          LoginRegisterSourceEnum.getInstance(createReqDTO.getLoginRegisterSource()),
          userLoginTypeEnum);
      result = userExtendMapper.insert(userExtend);
      if (result > 0 && userLoginTypeEnum == UserLoginTypeEnum.LOGIN_BY_THIRD_PARTY) {
        // 第三方登录
        UserThirdDO userThirdDO = UserThirdConvert.INSTANCE.convert(createReqDTO);
        userThirdDO.setUserId(userInfoDO.getId());
        userThirdMapper.insert(userThirdDO);
      }
    }
    return UserInfoConvert.INSTANCE.convert(userInfoDO);
  }

  /**
   * 构建初始化用户扩展信息
   *
   * @param ip
   * @param userId
   * @param loginRegisterSourceEnum
   * @param registerTypeEnum
   * @return
   */
  private UserExtendDO buildUserExtend(String ip, Long userId,
      LoginRegisterSourceEnum loginRegisterSourceEnum, UserLoginTypeEnum registerTypeEnum) {
    UserExtendDO userExtend = new UserExtendDO()
        .setUserId(userId)
        .setEmail("")
        .setWeixin("")
        .setGender(GenderEnum.UNKNOWN.getValue())
        .setRealName("")
        .setIdcard(StringUtils.generateRandomCode(18))
        .setCompanyName("")
        .setRegisterTime(new Date())
        .setUserRole(this.userRole(loginRegisterSourceEnum))
        .setIdentityType(IdentityTypeEnum.WORKPLACE.getValue())
        .setEnabledGreet(CommonStatusEnum.ENABLE.getValue())
        .setEnabledInterviewNotice(CommonStatusEnum.ENABLE.getValue())
        .setEnabledHide(CommonStatusEnum.DISABLE.getValue())
        .setRegisterIp(ip)
        .setRegisterType(registerTypeEnum.getValue())
        .setExpireFreeze(new Date())
        .setFreezeReason("")
        .setTerminalType(this.terminalType(loginRegisterSourceEnum))
        .setTerminalSn("")
        .setTerminalName("");
    return userExtend;
  }

  /**
   * 根据登录来源,初始角色值
   *
   * @param loginRegisterSourceEnum
   * @return
   */
  private Integer userRole(LoginRegisterSourceEnum loginRegisterSourceEnum) {
    if (loginRegisterSourceEnum == LoginRegisterSourceEnum.USER) {
      return UserRoleEnum.USER.getValue();
    }
    // 通过企业小程序或者企业PC登录注册
    if (loginRegisterSourceEnum == LoginRegisterSourceEnum.COMPANY
        || loginRegisterSourceEnum == LoginRegisterSourceEnum.COMPANY_PC) {
      return UserRoleEnum.COMPANY_USER.getValue();
    }
    // 未知
    return 0;
  }

  /**
   * 设备类型
   *
   * @param loginRegisterSourceEnum
   * @return
   */
  private Integer terminalType(LoginRegisterSourceEnum loginRegisterSourceEnum) {
    if (loginRegisterSourceEnum == LoginRegisterSourceEnum.USER
        || loginRegisterSourceEnum == LoginRegisterSourceEnum.COMPANY) {
      return TerminalTypeEnum.SMALL_ROUTINE.getValue();
    }

    if (loginRegisterSourceEnum == LoginRegisterSourceEnum.COMPANY_PC) {
      return TerminalTypeEnum.PC.getValue();
    }
    return 0;
  }


  /**
   * 构建用户信息
   *
   * @param userInfoDO
   * @return
   */
  private UserInfoDO buildUserInfo(UserInfoDO userInfoDO) {
    final String password = this.genPassword(userInfoDO.getPassword());
    //设置一下昵称
    final String nickname = this.genNickname(userInfoDO.getNickname());
    // 生成随机签名
    final String signature = this.genSignature(userInfoDO.getSignature());
    userInfoDO
        .setPassword(password)
        .setNickname(nickname)
        .setSignature(signature)
        .setUserStatus(UserStatusEnum.NORMAL.getValue())
        .setAvatarUrl("")
        .setUserStatus(UserStatusEnum.NORMAL.getValue())
        .setUserType(UserTypeEnum.ORDINARY_USER.getValue());
    return userInfoDO;
  }


  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  @Transactional(rollbackFor = ServiceException.class)
  public int updateUserInfo(UserInfoUpdateReqDTO updateReqDTO) {
    UserExtendDO userExtendDO = userExtendMapper.selectByUserId(updateReqDTO.getId());
    if (userExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    userExtendDO.setIdentityType(updateReqDTO.getIdentityType());
    userExtendDO.setRealName(updateReqDTO.getRealName());
    userExtendDO.setGender(updateReqDTO.getGender());
    int result = userExtendMapper.updateById(userExtendDO);
    UserResumeDO userResumeDO = userResumeMapper.selectByUserId(updateReqDTO.getId());
    // 简历为空需新建用户简历
    if (userResumeDO == null) {
      userResumeDO = userResume(updateReqDTO);
      userResumeMapper.insert(userResumeDO);
    }
    userResumeDO.setBirthdayYear(updateReqDTO.getBirthdayYear());
    userResumeDO.setBirthdayMonth(updateReqDTO.getBirthdayMonth());
    userResumeDO.setParticipateJob(updateReqDTO.getParticipateJob());
    userResumeMapper.updateById(userResumeDO);
    if (updateReqDTO.getAvatarUrl() != null) {
      UserInfoDO userInfoDO = userInfoMapper.selectUserInfoByUserId(updateReqDTO.getId());
      userInfoDO.setAvatarUrl(updateReqDTO.getAvatarUrl());
      userInfoMapper.updateById(userInfoDO);
    }
    return result;
  }

  /**
   * 构造用户简历
   *
   * @param updateReqDTO
   * @return
   */
  private UserResumeDO userResume(UserInfoUpdateReqDTO updateReqDTO) {
    UserResumeDO userResumeDO = new UserResumeDO();
    userResumeDO.setUserId(updateReqDTO.getId());
    userResumeDO.setBirthdayYear(updateReqDTO.getBirthdayYear());
    userResumeDO.setBirthdayMonth(updateReqDTO.getBirthdayMonth());
    if (updateReqDTO.getParticipateJob() == null) {
      userResumeDO.setParticipateJob(0);
      userResumeDO.setWorkYearTotal(0);
    }
    DateTime workTotal = DateUtil
        .parse(updateReqDTO.getParticipateJob().toString(), "yyyyMM");
    userResumeDO.setParticipateJob(updateReqDTO.getParticipateJob());
    userResumeDO.setWorkYearTotal((int) DateUtil.betweenYear(workTotal, new Date(), true));
    userResumeDO.setEvaluate("");
    userResumeDO.setPositionWantedDictionaryId(5L);
    userResumeDO.setPositionWantedStatusName("在职-考虑机会");
    userResumeDO.setIsOpen(0);
    return userResumeDO;
  }


  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserInfo(Long id) {
    if (userInfoMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = userInfoMapper.deleteById(id);
    return result;
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserInfoRespDTO> listUserInfos(UserInfoListQueryReqDTO listQueryReqDTO) {
    List<UserInfoDO> list = userInfoMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return UserInfoConvert.INSTANCE.convertList(list);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public UserInfoRespDTO getUserInfo(Long id) {
    UserInfoDO userInfoDO = userInfoMapper.selectById(id);
    if (userInfoDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return UserInfoConvert.INSTANCE.convert(userInfoDO);
  }

  /**
   * 根据用户id 查询 用户拓简历资料
   *
   * @param userId
   * @return
   */
  public UserPersonalInfoRespDTO getUserInfoById(Long userId) {
    UserPersonalInfoDO userPersonalInfoDO = userInfoMapper.getUserInfoById(userId);
    return UserInfoConvert.INSTANCE.convert(userPersonalInfoDO);
  }


  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserInfoRespDTO> pageUserInfo(UserInfoPageReqDTO page) {
    IPage<UserInfoDO> userInfoPage = userInfoMapper.selectPage(page);
    return UserInfoConvert.INSTANCE.convertPage(userInfoPage);
  }

  /**
   * 查找用户来自于手机号码
   *
   * @param username
   * @return
   */
  public UserInfoRespDTO getUserInfoByMobile(String username) {
    UserInfoDO userInfoDO = userInfoMapper.selectByMobile(username);
    return UserInfoConvert.INSTANCE.convert(userInfoDO);
  }

  /**
   * 验证密码是否正确
   *
   * @param username
   * @param password
   * @return
   */
  public UserInfoRespDTO verifyPassword(String username, String password) {
    UserInfoDO userInfoDO = userInfoMapper.selectByMobile(username);
    if (userInfoDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USERNAME_NOT_EXISTS.getCode());
    }

    if (!encoder.matches(password, userInfoDO.getPassword())) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.PASSWORD_ERROR.getCode());
    }

    if (!UserStatusEnum.NORMAL.getValue().equals(userInfoDO.getUserStatus())) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_IS_DISABLE.getCode());
    }
    return UserInfoConvert.INSTANCE.convert(userInfoDO);
  }

  /**
   * 设置密码
   *
   * @param username
   * @param password
   * @return
   */
  public boolean setPassword(String username, String password) {
    UserInfoDO userInfoDO = userInfoMapper.selectByMobile(username);
    if (userInfoDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USERNAME_NOT_EXISTS.getCode());
    }
    if (!UserStatusEnum.NORMAL.getValue().equals(userInfoDO.getUserStatus())) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_IS_DISABLE.getCode());
    }
    //对密码进行加密
    password = encoder.encode(password);
    userInfoDO.setPassword(password);
    int result = userInfoMapper.updateById(userInfoDO);
    return result > 0 ? true : false;
  }

  /**
   * 更新手机号码
   *
   * @param username
   * @param mobile
   * @return
   */
  public boolean updateMobile(String username, String mobile) {
    UserInfoDO userInfoDO = userInfoMapper.selectByMobile(username);
    if (userInfoDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USERNAME_NOT_EXISTS.getCode());
    }
    if (!UserStatusEnum.NORMAL.getValue().equals(userInfoDO.getUserStatus())) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_IS_DISABLE.getCode());
    }
    userInfoDO.setMobile(mobile);
    int result = userInfoMapper.updateById(userInfoDO);
    return result > 0 ? true : false;
  }

  /**
   * 修改密码
   *
   * @param username
   * @param oldPassword
   * @param password
   * @return
   */
  public boolean updatePassword(String username, String oldPassword, String password) {
    UserInfoDO userInfoDO = userInfoMapper.selectPassword(username);
    if (userInfoDO == null) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USERNAME_NOT_EXISTS.getCode());
    }

    if (!encoder.matches(oldPassword, userInfoDO.getPassword())) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.OLD_PASSWORD_ERROR.getCode());
    }

    if (!UserStatusEnum.NORMAL.getValue().equals(userInfoDO.getUserStatus())) {
      throw ServiceExceptionUtil
          .exception(UserErrorCodeConstants.USER_IS_DISABLE.getCode());
    }

    //设置新的密码
    password = encoder.encode(password);
    userInfoDO.setPassword(password);
    int result = userInfoMapper.updateById(userInfoDO);
    return result > 0 ? true : false;
  }

  /**
   * 如果密码为空就生成一个随机数为密码
   *
   * @return
   */
  private String genPassword(String password) {
    if (!StringUtils.hasText(password)) {
      // 为空的密码，生成简单随机数为密码
      password = StringUtils.uuid(true);
    }
    password = encoder.encode(password);
    return password;
  }

  /**
   * 如果昵称为空就生成一个随机昵称
   * <p>
   * 后续生成昵称可以优化
   * </p>
   *
   * @param nickname
   * @return
   */
  private String genNickname(String nickname) {
    if (!StringUtils.hasText(nickname)) {
      // 默认初始化一个昵称
      nickname =
          "sentence_" + StringUtils.generateRandomCode(5);
    }
    return nickname;
  }

  /**
   * 生成签名
   *
   * @param signature
   * @return
   */
  private String genSignature(String signature) {
    if (!StringUtils.hasText(signature)) {
      // 默认初始化一个签名
      signature = StringUtils.generateRandomCode(7);
    }
    return signature;
  }


  /**
   * 根据用户ids 查询用户信息
   *
   * @param userIds 简历id
   * @return
   */
  public List<UserInfoRespDTO> listUserInfoByUserIds(Set<Long> userIds) {
    List<UserInfoDO> userInfoList = userInfoMapper.listUserInfoByUserIds(userIds);
    if (CollectionUtils.isEmpty(userInfoList)) {
      return Collections.emptyList();
    }
    return UserInfoConvert.INSTANCE.convertList(userInfoList);
  }

  /**
   * 根据用户ids 查询用户信息以及拓展信息
   * @param userIds
   * @return
   */
  public List<UserPersonalInfoRespDTO> listUserPersonalInfo(Set<Long> userIds) {
    List<UserPersonalInfoDO> userPersonalInfoList = userInfoMapper.listUserPersonalInfo(userIds);
    if (CollectionUtils.isEmpty(userPersonalInfoList)) {
      return Collections.emptyList();
    }
    return UserInfoConvert.INSTANCE.convertPersonalList(userPersonalInfoList);
  }
}
