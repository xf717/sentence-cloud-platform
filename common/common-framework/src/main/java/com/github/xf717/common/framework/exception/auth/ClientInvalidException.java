package com.github.xf717.common.framework.exception.auth;

import com.github.xf717.common.framework.constant.CommonConstants;
import com.github.xf717.common.framework.exception.BaseException;

/**
 * @author xiaofeng
 * @date 2017/9/10
 */
public class ClientInvalidException extends BaseException {

  public ClientInvalidException(String message) {
    super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
  }
}
