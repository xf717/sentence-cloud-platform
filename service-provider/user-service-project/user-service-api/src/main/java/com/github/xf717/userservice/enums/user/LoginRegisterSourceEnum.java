package com.github.xf717.userservice.enums.user;

import com.github.xf717.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * 注册类型
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 15:02
 */
public enum LoginRegisterSourceEnum implements IntArrayValuable {
  /**
   * 求职端
   */
  USER(1, "求职端小程序"),
  /**
   * 企业端
   */
  COMPANY(2, "企业端小程序"),

  /**
   * 企业PC 端
   */
  COMPANY_PC(2, "企业端PC");

  public static final int[] ARRAYS = Arrays.stream(values())
      .mapToInt(LoginRegisterSourceEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  LoginRegisterSourceEnum(Integer value, String name) {
    this.value = value;
    this.name = name;
  }

  /**
   * 根据value 获取枚举对象
   *
   * @param value
   * @return
   */
  public static LoginRegisterSourceEnum getInstance(final Integer value) {
    LoginRegisterSourceEnum[] loginRegisterSourceEnums = LoginRegisterSourceEnum.values();
    for (LoginRegisterSourceEnum loginRegisterSourceEnum : loginRegisterSourceEnums) {
      if (loginRegisterSourceEnum.value.equals(value)) {
        return loginRegisterSourceEnum;
      }
    }
    return USER;
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
