package com.db.chaomaxs.userservice.enums.user;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * RegisterTypeEnum
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 15:02
 */
public enum RegisterTypeEnum implements IntArrayValuable {
  /**
   * 邮箱
   */
  EMAIL(1, "邮箱"),
  /**
   * 手机
   */
  MOBILE(2, "手机"),
  /**
   * 第三方注册
   */
  THIRD_PARTY(3, "第三方注册"),

  /**
   * 批量注册
   */
  BATCH(4, "批量注册");

  private final Integer value;
  private final String name;


  ;

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(RegisterTypeEnum::getValue)
      .toArray();

  RegisterTypeEnum(Integer value, String name) {
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
