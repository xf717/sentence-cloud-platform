package com.db.chaomaxs.common.framework.msg.auth;

import com.db.chaomaxs.common.framework.constant.RestCodeConstants;
import com.db.chaomaxs.common.framework.msg.BaseResponse;

/**
 * @author xiaofeng
 * @date 2017/8/25
 */
public class TokenForbiddenResponse extends BaseResponse {

  public TokenForbiddenResponse(String message) {
    super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
  }
}
