package com.db.chaomaxs.common.framework.vo;

import java.io.Serializable;

/**
 * 排序字段 DTO
 * <p>
 * 类名加了 ing 的原因是，避免和 ES SortField 重名。
 *
 * @author xiaofeng
 */
public class SortingField implements Serializable {

  private static final long serialVersionUID = -4820329363613103650L;

  /**
   * 顺序 - 升序
   */
  public static final String ORDER_ASC = "asc";
  /**
   * 顺序 - 降序
   */
  public static final String ORDER_DESC = "desc";

  /**
   * 字段
   */
  private String field;
  /**
   * 顺序
   */
  private String order;

  // 空构造方法，解决反序列化
  public SortingField() {
  }

  public SortingField(String field, String order) {
    this.field = field;
    this.order = order;
  }

  public String getField() {
    return field;
  }

  public SortingField setField(String field) {
    this.field = field;
    return this;
  }

  public String getOrder() {
    return order;
  }

  public SortingField setOrder(String order) {
    this.order = order;
    return this;
  }
}