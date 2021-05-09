package com.db.chaomaxs.common.framework.exception.auth;


import com.db.chaomaxs.common.framework.constant.CommonConstants;
import com.db.chaomaxs.common.framework.exception.BaseException;

/**
 * @author xiaofeng
 * @date 2017/9/12
 */
public class ClientForbiddenException extends BaseException {

  public ClientForbiddenException(String message) {
    super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
  }

}
