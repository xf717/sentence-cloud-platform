package com.db.chaomaxs.systemservice.enums.opinionfeedback;

/**
 * ReleasePlatformType 类型枚举
 *
 * @author ding
 */
public enum ReleasePlatformTypeEnum {

  JOB_HUNTING(1, "求职端"),
  COMPANY(2, "企业端"),
  PC(3, "PC"),
  WEIXIN(4, "微信");


  /**
   * key
   */
  private final Integer key;
  /**
   * value
   */
  private final String value;

  ReleasePlatformTypeEnum(Integer key, String value) {
    this.key = key;
    this.value = value;
  }

  public Integer getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public static String getValue(Integer key) {
    for (ReleasePlatformTypeEnum value : values()) {
      if (value.getKey().equals(key)) {
        return value.getValue();
      }
    }
    return null;
  }
}
