package com.github.xf717.systemservice.enums.ProblemInformation;

/**
 * ProblemInformationPlatform 类型枚举
 *
 * @author ding
 */
public enum ProblemInformationPlatformEnum {

  JOB_HUNTING(1, "求职端"),
  COMPANY(2, "企业端");


  /**
   * key
   */
  private final Integer key;
  /**
   * value
   */
  private final String value;

  ProblemInformationPlatformEnum(Integer key, String value) {
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
    for (ProblemInformationPlatformEnum value : values()) {
      if (value.getKey().equals(key)) {
        return value.getValue();
      }
    }
    return null;
  }
}
