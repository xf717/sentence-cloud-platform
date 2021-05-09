package com.github.xf717.userservice.enums.user;

import com.github.xf717.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * 身份类型
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 19:49
 */
public enum IdentityTypeEnum implements IntArrayValuable {

  /**
   * 职场
   */
  WORKPLACE(1, "职场"),
  /**
   * 学生
   */
  STUDENT(2, "学生");

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(IdentityTypeEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  IdentityTypeEnum(Integer value, String name) {
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
