package com.db.chaomaxs.userservice.enums;


import com.db.chaomaxs.common.framework.exception.ErrorCode;

/**
 * 错误码枚举类
 * <p>
 * user 系统，使用 1-001-000-000 段
 *
 * @author xiaofeng
 */
public interface UserErrorCodeConstants {

  // ========== OAUTH2 模块 ==========
  // 预留
  ErrorCode OAUTH2_UNKNOWN = new ErrorCode(1001001000, "未知错误");
  ErrorCode NOT_EXISTS = new ErrorCode(1001001001, "不存在");
  ErrorCode USERNAME_NOT_EXISTS = new ErrorCode(1001001002, "账号不存在");
  ErrorCode ACCOUNT_LOCK = new ErrorCode(100101003, "该用户已被锁定，请联系运营人员");
  ErrorCode PASSWORD_ERROR = new ErrorCode(1001001003, "密码错误");
  ErrorCode THIRDIDEN_ERROR = new ErrorCode(1001001004, "第三方唯一标识错误");
  ErrorCode CREATE_USER_THIRD_ERROR = new ErrorCode(1001001005, "创建第三方用户错误");
  ErrorCode OLD_PASSWORD_ERROR = new ErrorCode(1001001006, "旧密码错误");
  ErrorCode USER_IS_DISABLE = new ErrorCode(1001001007, "账号被禁用");
  ErrorCode CREATE_USER_ERROR = new ErrorCode(1001001008, "创建用户错误");
  ErrorCode CREATE_USER_EXTEND_ERROR = new ErrorCode(1001001008, "创建用户扩展信息错误");
  ErrorCode USER_EXTEND_NOT_EXISTS = new ErrorCode(1001001009, "用户扩展信息不存在");
  ErrorCode USER_ROLE_LOGIN_ERROR = new ErrorCode(1001001010, "用户角色登录错误，请切换角色");
  ErrorCode USER_THIRD_PARTY_BIND_ERROR = new ErrorCode(1001001011, "用户第三方绑定错误");
  ErrorCode LOGIN_BY_SMS_ERROR = new ErrorCode(1001001012, "验证码登录错误");


  // ========== 用户手机验证码模块 ==========
  ErrorCode USER_SMS_CODE_NOT_FOUND = new ErrorCode(1001001200, "验证码不存在");
  ErrorCode USER_SMS_CODE_EXPIRED = new ErrorCode(1001001201, "验证码已过期");
  ErrorCode USER_SMS_CODE_USED = new ErrorCode(1001001202, "验证码已使用");
  ErrorCode USER_SMS_CODE_NOT_CORRECT = new ErrorCode(1001001203, "验证码不正确");
  ErrorCode USER_SMS_CODE_EXCEED_SEND_MAXIMUM_QUANTITY_PER_DAY = new ErrorCode(1001001204,
      "超过每日短信发送数量");
  ErrorCode USER_SMS_CODE_SEND_TOO_FAST = new ErrorCode(1001001205, "短信发送过于频率");

  // ========== 用户地址 ==========
  ErrorCode USER_ADDRESS_NOT_FOUND = new ErrorCode(1001004000, "用户地址不存在!");
  ErrorCode USER_GET_ADDRESS_NOT_EXISTS = new ErrorCode(1001004001, "获取的地址不存在!");

  // -----------简历-----------
  ErrorCode NOT_RESUME = new ErrorCode(1001002001, "用户简历不存在");
  ErrorCode USER_EDUEXPERIENCE_MORE_THAN_TEN = new ErrorCode(1001002002, "教育经历最多添加十条");
  ErrorCode USER_CREDENTIAL_MORE_THAN_TEN = new ErrorCode(1001002003, "资格证书最多添加十条");
  ErrorCode USER_EXPECTED_POSITION_MORE_THAN_THREE = new ErrorCode(1001002004, "期望职位最多添加三条");
  ErrorCode USER_PROFESSIONAL_SKILL_MORE_THAN_TEN = new ErrorCode(1001002005, "专业技能最多添加十条");
  ErrorCode USER_PROJECT_EXPERIENCE_MORE_THAN_TEN = new ErrorCode(1001002006, "项目经历最多添加十条");
  ErrorCode USER_WORK_EXPERIENCE_MORE_THAN_TEN = new ErrorCode(1001002007, "工作经历最多添加十条");
  ErrorCode UPDATE_PERSONAL_INFO_FAIL = new ErrorCode(1001002008, "更新个人资料失败");
  ErrorCode PERSONAL_INFO_NOT_EXISTS = new ErrorCode(1001002009, "个人资料不存在");
  ErrorCode USER_EXPECTED_POSITION_NOT_EXISTS = new ErrorCode(1001002010, "求职期望不存在");
  ErrorCode USER_WORK_EXPERIENCE_NOT_EXISTS = new ErrorCode(1001002011, "工作经历不存在");
  ErrorCode USER_SIGN_ALREADY_EXISTS = new ErrorCode(1001002012, "今天已签到了");

  /**
   * 用户招聘拓展
   */
  ErrorCode USER_RECRUIT_EXISTS = new ErrorCode(1001003001, "用户招聘不存在");
  ErrorCode COMPANY_ID_NULL = new ErrorCode(1001003001, "企业id为空");

}
