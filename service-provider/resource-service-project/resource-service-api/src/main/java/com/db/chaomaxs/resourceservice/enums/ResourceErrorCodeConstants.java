package com.db.chaomaxs.resourceservice.enums;


import com.db.chaomaxs.common.framework.exception.ErrorCode;

/**
 * 错误码枚举类
 * <p>错误码区间 [1-003-000-000 ~ 1-003-000-000]
 *
 * @author xiaofeng
 */
public interface ResourceErrorCodeConstants {

  // ========== 资源模块 模块 ==========

  /**
   * 资源不存在 编号待定
   */
  ErrorCode RESOURCE_NOT_EXISTS = new ErrorCode(1003000001, "资源不存在");

  /**
   * 文件不能为空
   */
  ErrorCode FILE_NOT_EMPTY = new ErrorCode(1003000002, "资源文件不能为空");

  /**
   * 上传失败
   */
  ErrorCode UPLOAD_ERROR = new ErrorCode(1003000003, "上传失败");

  /**
   * 资源保存错误
   */
  ErrorCode RESOURCE_SAVE_ERROR = new ErrorCode(1003000004, "资源保存错误");


}
