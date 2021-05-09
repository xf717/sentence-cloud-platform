package com.db.chaomaxs.companyservice.enums.welfare;

/**
 * @author hlf
 * @description: 公司福利类型枚举
 * @date 2021-04-25 15:31
 */
public enum CompanyWelfareTypeEnum {

  /**
   * 通用类型
   */
  GENERAL(0),
  /**
   * 自定义类型
   */
  CUSTOM(1);

  private Integer value;

  CompanyWelfareTypeEnum(Integer value) {
        this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
