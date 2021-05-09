package com.github.xf717.common.framework.msg.auth;

import com.github.xf717.common.framework.constant.RestCodeConstants;
import com.github.xf717.common.framework.msg.BaseResponse;

/**
 * @author xiaofeng
 * @date 2017/8/23
 */
public class TokenErrorResponse extends BaseResponse {

  public TokenErrorResponse(String message) {
    super(RestCodeConstants.TOKEN_ERROR_CODE, message);
  }
}
