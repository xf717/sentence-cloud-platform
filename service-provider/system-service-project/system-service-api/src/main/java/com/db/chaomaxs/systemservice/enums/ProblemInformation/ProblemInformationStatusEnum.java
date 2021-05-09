package com.db.chaomaxs.systemservice.enums.ProblemInformation;

/**
 * ProblemInformationStatus 类型枚举
 *
 * @author ding
 */
public enum ProblemInformationStatusEnum {

  UNPUBLISH(0, "待发布"),
  PUBLISHED(1, "已发布");


  /**
   * 状态key
   */
  private final Integer key;
  /**
   * 状态value
   */
  private final String value;

  ProblemInformationStatusEnum(Integer key, String value) {
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
    for (ProblemInformationStatusEnum value : values()) {
      if (value.getKey().equals(key)) {
        return value.getValue();
      }
    }
    return null;
  }
}
