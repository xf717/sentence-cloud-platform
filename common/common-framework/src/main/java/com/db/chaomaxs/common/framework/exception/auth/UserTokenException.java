package com.db.chaomaxs.common.framework.exception.auth;

import com.db.chaomaxs.common.framework.constant.CommonConstants;
import com.db.chaomaxs.common.framework.exception.BaseException;

/**
 * @author xiaofeng
 * @date 2017/9/8
 */
public class UserTokenException extends BaseException {

  public UserTokenException(String message) {
    super(message, CommonConstants.EX_USER_INVALID_CODE);
  }
}
