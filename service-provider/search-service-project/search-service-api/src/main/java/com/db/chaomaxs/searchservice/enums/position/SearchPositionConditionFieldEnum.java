package com.db.chaomaxs.searchservice.enums.position;

/**
 * 搜索职位条件的字段枚举
 *
 * @author xiaofeng
 */
public enum SearchPositionConditionFieldEnum {
  /**
   * TODO 后续在定义下
   */
  CATEGORY("category");

  /**
   * 字段
   */
  private final String field;

  SearchPositionConditionFieldEnum(String field) {
    this.field = field;
  }

  public String getField() {
    return field;
  }

}
