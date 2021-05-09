package com.db.chaomaxs.positionservice.enums;


import com.db.chaomaxs.common.framework.exception.ErrorCode;

/**
 * 错误码枚举类
 * <p>错误码区间 [1-006-000-000 ~ 1-006-000-000]
 */
public interface PositionErrorCodeConstants {

  // ========== Banner 模块 ==========

  /**
   * 资源不存在 编号待定
   */
  ErrorCode NOT_EXISTS = new ErrorCode(-1, "不存在");


  ErrorCode POSITION_TYPE_EXISTS = new ErrorCode(1006001001, "分类已存在");

  ErrorCode POSITION_TYPE_NOT_EXISTS = new ErrorCode(1006001002,"分类不存在");


  ErrorCode PARAMETER_NULL = new ErrorCode(1006001003,"参数为空");

}
