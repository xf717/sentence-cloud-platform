package com.db.chaomaxs.userservice.enums.user;

import com.db.chaomaxs.common.framework.core.IntArrayValuable;
import java.util.Arrays;

/**
 * ThirdPartyLoginType
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/12 11:12
 */
public enum ThirdPartyLoginTypeEnum implements IntArrayValuable {

  /**
   * 小程序
   */
  SMALL_ROUTINE(1, "小程序"),

  /**
   * 微信扫码登录
   */
  WX_MP_QR(2, "微信扫码登录"),

  /**
   * 微信公众号
   */
  WX_MP(3, "微信公众号");

  public static final int[] ARRAYS = Arrays.stream(values())
      .mapToInt(ThirdPartyLoginTypeEnum::getValue)
      .toArray();

  private final Integer value;
  private final String name;

  ThirdPartyLoginTypeEnum(Integer value, String name) {
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
