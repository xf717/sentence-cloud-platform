package com.github.xf717.userservice.enums.user;

import com.github.xf717.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * 用户类型
 *
 * @author wst, xiaofeng
 * @date 2021/4/6 16:59
 */

public enum UserTypeEnum implements IntArrayValuable {

  /**
   * 普通用户
   */
  ORDINARY_USER(1, "普通用户"),
  /**
   * 企业用户
   */
  COMPANY_USER(2, "企业用户"),

  /**
   * 运营用户
   */
  OPERATING_USER(3, "运营用户");

  private final Integer value;
  private final String name;

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserTypeEnum::getValue)
      .toArray();

  UserTypeEnum(Integer value, String name) {
    this.value = value;
    this.name = name;
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
