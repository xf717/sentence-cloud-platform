package com.db.chaomaxs.searchservice.enums;

import com.db.chaomaxs.common.framework.exception.ErrorCode;

/**
 * 错误码枚举类
 * <p>错误码区间 [1-007-000-000 ~ 1-007-000-000]
 *
 * @author xiaofeng
 */
public interface SearchErrorCodeConstants {

  // ========== 资源模块 模块 ==========

  /**
   * 搜索资源不存在
   */
  ErrorCode SEARCH_NOT_EXISTS = new ErrorCode(1007000001, "不存在");


}
