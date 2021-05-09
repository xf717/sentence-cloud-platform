package com.github.xf717.systemservice.enums.opinionfeedback;

/**
 * HandleStatus 类型枚举
 *
 * @author ding
 */
public enum HandleStatusEnum {

  PENDING(0, "待处理"),
  PROCESSING(1, "处理中"),
  PROCESSED(2, "已处理");


  /**
   * key
   */
  private final Integer key;
  /**
   * value
   */
  private final String value;

  HandleStatusEnum(Integer key, String value) {
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
    for (HandleStatusEnum value : values()) {
      if (value.getKey().equals(key)) {
        return value.getValue();
      }
    }
    return null;
  }
}
