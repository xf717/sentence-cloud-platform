package com.db.chaomaxs.searchservice.enums.position;

/**
 * 搜索职位分页查询的排序字段枚举
 *
 * @author xiaofeng
 */
public enum SearchPositionPageQuerySortFieldEnum {

  /**
   * 职位名称
   */
  POSITION_NAME("positionName");

  /**
   * 字段
   */
  private final String field;

  SearchPositionPageQuerySortFieldEnum(String field) {
    this.field = field;
  }

  public String getField() {
    return field;
  }

  public static boolean contains(String field) {
    for (SearchPositionPageQuerySortFieldEnum fieldEnum : values()) {
      if (field.equals(fieldEnum.getField())) {
        return true;
      }
    }
    return false;
  }

}
