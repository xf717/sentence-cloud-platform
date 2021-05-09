package com.github.xf717.common.framework.exception.auth;

import com.github.xf717.common.framework.constant.CommonConstants;
import com.github.xf717.common.framework.exception.BaseException;

/**
 * @author xiaofeng
 * @date 2017/9/8
 */
public class UserInvalidException extends BaseException {

  public UserInvalidException(String message) {
    super(message, CommonConstants.EX_USER_PASS_INVALID_CODE);
  }
}
