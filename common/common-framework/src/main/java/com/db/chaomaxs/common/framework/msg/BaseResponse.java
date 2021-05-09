package com.db.chaomaxs.common.framework.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.db.chaomaxs.common.framework.exception.GlobalException;
import com.db.chaomaxs.common.framework.exception.ServiceException;
import com.db.chaomaxs.common.framework.exception.enums.GlobalErrorCodeConstants;
import org.springframework.util.Assert;

/**
 * @author xiaofeng
 * @date 2017/8/23
 * @update xiaofeng
 */
public class BaseResponse {

  /**
   * 编码
   */
  private Integer code;

  /**
   * 错误提示，用户可阅读
   */
  private String message;

  /**
   * 错误明细，内部调试错误
   */
  private String detailMessage;


  public BaseResponse(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public BaseResponse(int code, String message, String detailMessage) {
    this.code = code;
    this.message = message;
    this.detailMessage = detailMessage;
  }


  public BaseResponse() {
  }

  /**
   * 错误
   *
   * @param code
   * @param message
   * @return
   */
  public static BaseResponse error(Integer code, String message) {
    return error(code, message, null);
  }


  /**
   * 错误，自定义状态值
   *
   * @param code          编码
   * @param message       信息
   * @param detailMessage 详细信息
   * @return
   */
  public static BaseResponse error(Integer code, String message, String detailMessage) {
    Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code), "code 必须是错误的！");
    return new BaseResponse(code, message, detailMessage);
  }

  /**
   * 成功
   *
   * @param message
   * @return
   */
  public static BaseResponse success(String message) {
    return new BaseResponse(GlobalErrorCodeConstants.SUCCESS.getCode(), message);
  }

  /**
   * 避免序列化
   */
  @JSONField(serialize = false)
  public boolean isSuccess() {
    return GlobalErrorCodeConstants.SUCCESS.getCode().equals(code);
  }

  /**
   * 避免序列化
   */
  @JSONField(serialize = false)
  public boolean isError() {
    return !isSuccess();
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDetailMessage() {
    return detailMessage;
  }

  public void setDetailMessage(String detailMessage) {
    this.detailMessage = detailMessage;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BaseResponse{");
    sb.append("code=").append(code);
    sb.append(", message='").append(message).append('\'');
    sb.append(", detailMessage='").append(detailMessage).append('\'');
    sb.append('}');
    return sb.toString();
  }

  // ========= 和 Exception 异常体系集成 =========

  /**
   * 判断是否有异常。如果有，则抛出 {@link GlobalException} 或 {@link ServiceException} 异常
   */
  public void checkError() throws GlobalException, ServiceException {
    if (isSuccess()) {
      return;
    }
    // 全局异常
    if (GlobalErrorCodeConstants.isMatch(code)) {
      throw new GlobalException(code, message).setDetailMessage(detailMessage);
    }
    // 业务异常
    throw new ServiceException(code, message).setDetailMessage(detailMessage);
  }

  public static BaseResponse error(ServiceException serviceException) {
    return error(serviceException.getCode(), serviceException.getMessage(),
        serviceException.getDetailMessage());
  }

  public static BaseResponse error(GlobalException globalException) {
    return error(globalException.getCode(), globalException.getMessage(),
        globalException.getDetailMessage());
  }
}
