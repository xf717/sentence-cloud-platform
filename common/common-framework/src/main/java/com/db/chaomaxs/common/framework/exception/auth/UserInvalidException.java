package com.db.chaomaxs.common.framework.exception.auth;

import com.db.chaomaxs.common.framework.constant.CommonConstants;
import com.db.chaomaxs.common.framework.exception.BaseException;

/**
 * @author xiaofeng
 * @date 2017/9/8
 */
public class UserInvalidException extends BaseException {

  public UserInvalidException(String message) {
    super(message, CommonConstants.EX_USER_PASS_INVALID_CODE);
  }
}
