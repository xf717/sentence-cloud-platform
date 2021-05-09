package com.db.chaomaxs.userservice.enums.user;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * 性别
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 20:19
 */
public enum GenderEnum implements IntArrayValuable {

  /**
   * 男
   */
  MALE(1, "男"),

  /**
   * 女
   */
  WOMAN(2, "女"),

  /**
   * 未知
   */
  UNKNOWN(0, "未知");

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(GenderEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  GenderEnum(Integer value, String name) {
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
