package com.db.chaomaxs.userservice.manager.user;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.convert.user.UserThirdConvert;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.enums.user.LoginRegisterSourceEnum;
import com.db.chaomaxs.userservice.enums.user.UserLoginTypeEnum;
import com.db.chaomaxs.userservice.enums.user.UserRoleEnum;
import com.db.chaomaxs.userservice.enums.user.UserStatusEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPersonalInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdRespDTO;
import com.db.chaomaxs.userservice.service.user.UserExtendService;
import com.db.chaomaxs.userservice.service.user.UserInfoService;
import com.db.chaomaxs.userservice.service.user.UserThirdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * UserInfoManager
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Service
@Validated
public class UserInfoManager {

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private UserExtendService userExtendService;

  @Autowired
  private UserThirdService userThirdService;


  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveUserInfo(UserInfoCreateReqDTO createReqDTO) {
    return userInfoService.saveUserInfo(createReqDTO);
  }

  /**
   * 创建不存在的用户
   *
   * @param createReqDTO
   * @return
   */
  public UserInfoRespDTO createUserIfAbsent(UserInfoCreateReqDTO createReqDTO) {
    // 多种场景 1.手机验证码登录
    // 第三方登录：1.第一次登录，有手机号码，进行绑定(正常流程)  2.已经提前用手机号码登录过了，然后在用手机号码绑定
    UserInfoRespDTO userInfo = userInfoService.getUserInfoByMobile(createReqDTO.getMobile());
    if (userInfo != null) {

      if (!UserStatusEnum.NORMAL.getValue().equals(userInfo.getUserStatus())) {
        throw ServiceExceptionUtil
            .exception(UserErrorCodeConstants.USER_IS_DISABLE.getCode());
      }
      // 没有绑定用户进行绑定
      this.bindUserThird(createReqDTO, userInfo.getId());

      UserExtendRespDTO userExtendInfo = userExtendService.getUserExtendByUserId(userInfo.getId());
      UserRoleEnum userRoleEnum = UserRoleEnum.getInstance(userExtendInfo.getUserRole());
      final LoginRegisterSourceEnum loginRegisterSourceEnum = LoginRegisterSourceEnum
          .getInstance(createReqDTO.getLoginRegisterSource());
      // 验证角色是否正确
      this.verifyUserRole(userRoleEnum, loginRegisterSourceEnum);
      return userInfo;
    }
    // 用户不存在
    userInfo = userInfoService.createUser(createReqDTO);
    // TODO 可以将用户信息加入到缓存中
    return userInfo;
  }

  /**
   * 绑定第三方用户信息
   *
   * @param createReqDTO
   * @param userId
   */
  private void bindUserThird(UserInfoCreateReqDTO createReqDTO, Long userId) {
    if (createReqDTO.getUserLoginType()
        .equals(UserLoginTypeEnum.LOGIN_BY_THIRD_PARTY.getValue())) {
      UserThirdRespDTO userThirdInfo = userThirdService.getUserThirdByUserId(userId);
      // 没有绑定
      if (userThirdInfo == null) {
        UserThirdCreateReqDTO userThirdCreate = UserThirdConvert.INSTANCE
            .convertUserThird(createReqDTO);
        userThirdCreate.setUserId(userId);
        int result = userThirdService.saveUserThird(userThirdCreate);
        if (result <= 0) {
          throw ServiceExceptionUtil
              .exception(UserErrorCodeConstants.USER_THIRD_PARTY_BIND_ERROR.getCode());
        }
      }
    }
  }

  /**
   * 核实角色是否正常
   *
   * @param userRoleEnum
   * @param loginRegisterSourceEnum
   */
  private void verifyUserRole(UserRoleEnum userRoleEnum,
      LoginRegisterSourceEnum loginRegisterSourceEnum) {
    if (loginRegisterSourceEnum == LoginRegisterSourceEnum.USER) {
      // 求职端的用户不能登录到企业端，需要切换角色
      if (userRoleEnum == UserRoleEnum.COMPANY_USER) {
        throw ServiceExceptionUtil
            .exception(UserErrorCodeConstants.USER_ROLE_LOGIN_ERROR.getCode());
      }
    } else if ((loginRegisterSourceEnum == LoginRegisterSourceEnum.COMPANY_PC
        || loginRegisterSourceEnum == LoginRegisterSourceEnum.COMPANY)
        && userRoleEnum == UserRoleEnum.USER) {
      // 如果企业用户登录,当前用户的角色是USER，就进行切换
        throw ServiceExceptionUtil
            .exception(UserErrorCodeConstants.USER_ROLE_LOGIN_ERROR.getCode());

    }
  }


  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateUserInfo(UserInfoUpdateReqDTO updateReqDTO) {
    return userInfoService.updateUserInfo(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteUserInfo(Long id) {
    return userInfoService.deleteUserInfo(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<UserInfoRespDTO> listUserInfos(UserInfoListQueryReqDTO listQueryReqDTO) {
    return userInfoService.listUserInfos(listQueryReqDTO);
  }


  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<UserInfoRespDTO> pageUserInfo(UserInfoPageReqDTO page) {
    return userInfoService.pageUserInfo(page);
  }

  /**
   * 验证用户密码
   *
   * @param username
   * @param password
   * @return
   */
  public UserInfoRespDTO verifyPassword(String username, String password) {
    return userInfoService.verifyPassword(username, password);
  }

  /**
   * 更新手机号码
   *
   * @param mobile
   * @return
   */
  public boolean updateMobile(String username, String mobile) {
    return userInfoService.updateMobile(username, mobile);
  }

  /**
   * 设置密码
   *
   * @param username
   * @param password
   * @return
   */
  public boolean setPassword(String username, String password) {
    return userInfoService.setPassword(username, password);
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
    return userInfoService.updatePassword(username, oldPassword, password);
  }

  /**
   * 根据用户id 查询用户拓展信息和简历信息
   *
   * @param userId
   * @return
   */
  public UserPersonalInfoRespDTO getUserInfoById(Long userId) {
    return userInfoService.getUserInfoById(userId);
  }

}
