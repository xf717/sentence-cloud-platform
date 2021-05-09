package com.db.chaomaxs.userservice.enums.user;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * TerminalTypeEnum
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 19:55
 */
public enum TerminalTypeEnum implements IntArrayValuable {

  /**
   * 小程序
   */
  SMALL_ROUTINE(1, "小程序"),

  /**
   * 安卓手机
   */
  ANDROID(2, "android手机"),

  /**
   * PC
   */
  PC(3, "PC"),

  /**
   * IOS 手机
   */
  IOS(4, "ios手机"),

  /**
   * IOS 平板
   */
  IOS_TABLET(5, "ios 平板"),

  /**
   * WEB H5
   */
  WEB(6, "WEB H5");

  public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(TerminalTypeEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  TerminalTypeEnum(Integer value, String name) {
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
