package com.db.chaomaxs.userservice.enums.user;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * 用户登录类型
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/12 11:00
 */
public enum UserLoginTypeEnum implements IntArrayValuable {

  /**
   * 短信验证码登录
   */
  LOGIN_BY_SMS(1, "短信验证码登录"),

  /**
   * 帐号密码登录
   */
  LOGIN_BY_ACCOUNT_PASSWORD(2, "帐号密码登录"),

  /**
   * 第三方登录
   */
  LOGIN_BY_THIRD_PARTY(3, "第三方登录");




  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserLoginTypeEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  UserLoginTypeEnum(Integer value, String name) {
    this.value = value;
    this.name = name;
  }

  /**
   * 根据value 获取实例
   *
   * @param value
   * @return
   */
  public static UserLoginTypeEnum getInstance(final Integer value) {
    UserLoginTypeEnum[] userLoginTypeEnums = UserLoginTypeEnum.values();
    for (UserLoginTypeEnum userLoginTypeEnum : userLoginTypeEnums) {
      if (userLoginTypeEnum.value.equals(value)) {
        return userLoginTypeEnum;
      }
    }
    return LOGIN_BY_SMS;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  @Override
  public int[] array() {
    return ARRAYS;
  }
}
