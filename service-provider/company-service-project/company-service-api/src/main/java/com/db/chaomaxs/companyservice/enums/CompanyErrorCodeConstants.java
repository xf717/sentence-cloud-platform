package com.db.chaomaxs.companyservice.enums;


import com.db.chaomaxs.common.framework.exception.ErrorCode;

/**
 * 错误码枚举类
 * <p>
 * Company 企业，使用 1-005-000-000 段
 */
public interface CompanyErrorCodeConstants {

  /**
   * 错误代码不存在
   */
  ErrorCode NOT_EXISTS = new ErrorCode(1005001000, "未知错误");
  /**
   * 参数为空
   */
  ErrorCode PARAMETER_NULL = new ErrorCode(1005001001, "参数为空");
  /**
   * 查询结果为空
   */
  ErrorCode RESULT_NULL = new ErrorCode(1005001002, "查询结果为空");


  /**
   * 默认福利类型不存在
   */
  ErrorCode DEFAULT_WELFARE_NULL = new ErrorCode(1005001003, "默认福利类型不存在");

  /**
   * 默认福利类型不可编辑
   */
  ErrorCode DEFAULT_WELFARE_NOT_EDIT = new ErrorCode(1005001004, "默认福利类型不可编辑");
}
