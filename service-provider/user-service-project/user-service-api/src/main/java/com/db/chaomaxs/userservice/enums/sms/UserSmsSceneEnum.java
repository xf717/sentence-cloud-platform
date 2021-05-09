package com.db.chaomaxs.userservice.enums.sms;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * 用户短信验证码发送场景的枚举
 *
 * @author xiaofeng
 */
public enum UserSmsSceneEnum implements IntArrayValuable {

  /**
   * 未知
   */
  UNKNOWN(-1, "未知"),

  /**
   * 求职端手机号码登录
   */
  LOGIN_BY_SMS(1, "求职端手机号登陆"),
  /**
   * 求职端更换手机号码
   */
  UPDATE_MOBILE(2, "更换手机号"),

  /**
   * 设置新密码
   */
  UPDATE_PASSWORD(3, "设置新密码"),
  ;

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserSmsSceneEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  UserSmsSceneEnum(Integer value, String name) {
    this.value = value;
    this.name = name;
  }

  @Override
  public int[] array() {
    return ARRAYS;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

}
