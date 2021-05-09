package com.db.chaomaxs.common.framework.exception.auth;

import com.db.chaomaxs.common.framework.constant.CommonConstants;
import com.db.chaomaxs.common.framework.exception.BaseException;

/**
 * @author xiaofeng
 * @date 2017/9/10
 */
public class ClientTokenException extends BaseException {

  public ClientTokenException(String message) {
    super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
  }
}
