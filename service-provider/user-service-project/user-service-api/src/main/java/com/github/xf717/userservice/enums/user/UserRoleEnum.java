package com.github.xf717.userservice.enums.user;

import com.github.xf717.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * 用户角色枚举
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 19:42
 */
public enum UserRoleEnum implements IntArrayValuable {
  /**
   * 求职端用户
   */
  USER(1, "求职端用户"),
  /**
   * 企业端用户
   */
  COMPANY_USER(2, "企业端用户"),

  /**
   * 求职和招聘组合
   */
  COMPOSITE_USER(3, "求职和招聘");

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserRoleEnum::getValue)
      .toArray();


  private final Integer value;
  private final String name;

  UserRoleEnum(Integer value, String name) {
    this.value = value;
    this.name = name;
  }

  /**
   * 根据value 获取 UserRoleEnum
   *
   * @param value
   * @return
   */
  public static UserRoleEnum getInstance(final Integer value) {
    UserRoleEnum[] userRoleEnums = UserRoleEnum.values();
    for (UserRoleEnum userRoleEnum : userRoleEnums) {
      if (userRoleEnum.value.equals(value)) {
        return userRoleEnum;
      }
    }
    return UserRoleEnum.USER;
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
