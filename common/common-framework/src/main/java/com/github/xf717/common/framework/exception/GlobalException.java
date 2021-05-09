package com.github.xf717.common.framework.exception;

import com.github.xf717.common.framework.exception.enums.GlobalErrorCodeConstants;
import com.github.xf717.common.framework.vo.CommonResult;

/**
 * 全局异常 Exception
 *
 * @author xiaofeng
 */
public class GlobalException extends RuntimeException {

  /**
   * 全局错误码
   *
   * @see GlobalErrorCodeConstants
   */
  private Integer code;
  /**
   * 错误提示
   */
  private String message;
  /**
   * 错误明细，内部调试错误
   * <p>
   * 和 {@link CommonResult#getDetailMessage()} 一致的设计
   */
  private String detailMessage;

  /**
   * 空构造方法，避免反序列化问题
   */
  public GlobalException() {
  }

  public GlobalException(ErrorCode errorCode) {
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
  }

  public GlobalException(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public String getDetailMessage() {
    return detailMessage;
  }

  public GlobalException setDetailMessage(String detailMessage) {
    this.detailMessage = detailMessage;
    return this;
  }

  public GlobalException setCode(Integer code) {
    this.code = code;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public GlobalException setMessage(String message) {
    this.message = message;
    return this;
  }

}
