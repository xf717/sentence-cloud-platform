package com.github.xf717.common.framework.msg.auth;

import com.github.xf717.common.framework.constant.RestCodeConstants;
import com.github.xf717.common.framework.msg.BaseResponse;

/**
 * @author xiaofeng
 * @date 2017/8/25
 */
public class TokenForbiddenResponse extends BaseResponse {

  public TokenForbiddenResponse(String message) {
    super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
  }
}
