package com.github.xf717.common.framework.exception.auth;

import com.github.xf717.common.framework.constant.CommonConstants;
import com.github.xf717.common.framework.exception.BaseException;

/**
 * @author xiaofeng
 * @date 2017/9/8
 */
public class UserTokenException extends BaseException {

  public UserTokenException(String message) {
    super(message, CommonConstants.EX_USER_INVALID_CODE);
  }
}
