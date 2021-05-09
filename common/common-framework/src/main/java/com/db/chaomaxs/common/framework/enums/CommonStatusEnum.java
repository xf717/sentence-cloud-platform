package com.db.chaomaxs.common.framework.enums;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * 通用状态枚举
 */
public enum CommonStatusEnum implements IntArrayValuable {

  /**
   * 开启
   */
  ENABLE(1, "开启"),
  /**
   * 关闭
   */
  DISABLE(0, "关闭");

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(CommonStatusEnum::getValue)
      .toArray();

  /**
   * 状态值
   */
  private final Integer value;
  /**
   * 状态名
   */
  private final String name;

  CommonStatusEnum(Integer value, String name) {
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
