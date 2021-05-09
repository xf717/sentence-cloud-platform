package com.db.chaomaxs.userservice.enums.user;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * UserStatusEnum
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 14:11
 */
public enum UserStatusEnum implements IntArrayValuable {
  /**
   * 正常
   */
  NORMAL(1, "正常"),
  /**
   * 冻结
   */
  FREEZE(1, "冻结");

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserStatusEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  UserStatusEnum(Integer value, String name) {
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
